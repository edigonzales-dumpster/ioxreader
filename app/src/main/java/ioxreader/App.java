package ioxreader;

public class App {

    public static void main(String[] args) {
        GpkgValidator gpkgValidator = new GpkgValidator();
        gpkgValidator.validate();
        
        System.out.println("*************************************");
        
        CsvValidator csvValidator = new CsvValidator();
        csvValidator.validate();
    }
}
