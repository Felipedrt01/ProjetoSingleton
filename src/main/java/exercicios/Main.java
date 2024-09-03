package exercicios;

public class Main {
    public static void main(String[] args) {
        LicenseManager manager = LicenseManager.getInstance();
        if (manager.isLicenseValid()) {
            System.out.println("Licença válida: " + manager.getLicenseKey());
        } else {
            System.out.println("Licença inválida!");
        }
        manager.updateLicenseKey("WXYZ-9876-IJKL-4321");
        if (manager.isLicenseValid()) {
            System.out.println("Nova licença válida: " + manager.getLicenseKey());
        } else {
            System.out.println("Nova licença inválida!");
        }
    }
}
