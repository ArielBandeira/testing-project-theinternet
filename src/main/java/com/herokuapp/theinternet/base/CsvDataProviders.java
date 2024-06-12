package com.herokuapp.theinternet.base;
import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;
import com.opencsv.CSVReader;

public class CsvDataProviders {

    /**
     * CSV reader
     * @param method
     * @return list
     */
    @DataProvider(name = "csvDataProvider")
    public static Iterator<Object[]> csvDataProvider(Method method) {
        List<Object[]> list = new ArrayList<>();
        String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator
                + "dataproviders" + File.separator + method.getDeclaringClass().getSimpleName() + File.separator
                + method.getName() + ".csv";
        File file = new File(pathname);
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] keys = reader.readNext();
            if (keys != null) {
                String[] dataParts;
                while ((dataParts = reader.readNext()) != null) {
                    Map<String, String> testData = new HashMap<>();
                    for (int i = 0; i < keys.length; i++) {
                        testData.put(keys[i], dataParts[i]);
                    }
                    list.add(new Object[] { testData });
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + pathname + " was not found.\n" + e.getStackTrace().toString());
        } catch (IOException e) {
            throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return list.iterator();
    }

}