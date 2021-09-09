package ioxreader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.interlis2.validator.Validator;

import ch.ehi.basics.settings.Settings;
import ch.interlis.iom_j.csv.CsvReader;
import ch.interlis.ioxwkf.dbtools.IoxWkfConfig;

public class CsvValidator {
    
    public void validate() {
        boolean firstLineIsHeader = false;
        Character valueDelimiter = null;
        Character valueSeparator = null;
        String encoding = null;
        
        String fileName = "src/main/data/csv/data1.csv";
        String modelName = "CsvModel";

        List<String> files = new ArrayList<String>();
        files.add(new File(fileName).getAbsolutePath());
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_DISABLE_STD_LOGGER, Validator.TRUE);
        settings.setValue(Validator.SETTING_MODELNAMES, modelName);
        settings.setValue(Validator.SETTING_ILIDIRS, Validator.SETTING_DEFAULT_ILIDIRS);

        // set optional parameters
        settings.setValue(IoxWkfConfig.SETTING_FIRSTLINE, firstLineIsHeader ? IoxWkfConfig.SETTING_FIRSTLINE_AS_HEADER : IoxWkfConfig.SETTING_FIRSTLINE_AS_VALUE);
        if (valueDelimiter != null) {
            settings.setValue(IoxWkfConfig.SETTING_VALUEDELIMITER, valueDelimiter.toString());
        }
        if (valueSeparator != null) {
            settings.setValue(IoxWkfConfig.SETTING_VALUESEPARATOR, valueSeparator.toString());
        }
        if (encoding != null) {
            settings.setValue(CsvReader.ENCODING, encoding);
        }

        boolean validationOk = new CsvValidatorImpl().validate(files.toArray(new String[files.size()]), settings);
        System.out.println(validationOk);

    }

}
