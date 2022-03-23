package utill.properties;

public abstract class TestProperties {

    public static PropertyReader propertyReader = new PropertyReader();

    public final static String HOST = propertyReader.getProperty("host");

}