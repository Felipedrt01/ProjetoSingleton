package exercicios;

// Gerenciador de licenças

public class LicenseManager {

    private static LicenseManager instance;
    private String licenseKey;
    private boolean isValid;
    private LicenseManager() {
        this.licenseKey = "ABCD-1234-EFGH-5678";
        this.isValid = validateLicense(this.licenseKey);
    }
    public static synchronized LicenseManager getInstance() {
        if (instance == null) {
            instance = new LicenseManager();
        }
        return instance;
    }

    private boolean validateLicense(String key) {
        return key != null && key.matches("[A-Z0-9]{4}-[A-Z0-9]{4}-[A-Z0-9]{4}-[A-Z0-9]{4}");
    }
    public boolean isLicenseValid() {
        return isValid;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void updateLicenseKey(String newKey) {
        this.licenseKey = newKey;
        this.isValid = validateLicense(newKey);
    }
}
