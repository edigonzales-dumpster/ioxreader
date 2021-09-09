package ioxreader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.interlis2.validator.Validator;

import ch.ehi.basics.settings.Settings;
import ch.interlis.ioxwkf.dbtools.IoxWkfConfig;

public class GpkgValidator {
    
    public void validate() {
        String tableName = "Attributes";
        String modelName = "GpkgModel";
        String fileName = "src/main/data/gpkg/attributes.gpkg";
        
        List<String> files = new ArrayList<String>();
        files.add(new File(fileName).getAbsolutePath());
        
        Settings settings = new Settings();
        settings.setValue(IoxWkfConfig.SETTING_GPKGTABLE, tableName);
        settings.setValue(Validator.SETTING_DISABLE_STD_LOGGER, Validator.TRUE);
        settings.setValue(Validator.SETTING_MODELNAMES, modelName);
        settings.setValue(Validator.SETTING_ILIDIRS, Validator.SETTING_DEFAULT_ILIDIRS);

        boolean validationOk = new GpkgValidatorImpl().validate(files.toArray(new String[files.size()]), settings);
        System.out.println(validationOk);
        
                
    }
}
