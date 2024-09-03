package exercicios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LicenseManagerTest {

    @Test
    public void testSingletonInstance() {
        // Verificar se getInstance sempre retorna a mesma instância
        LicenseManager instance1 = LicenseManager.getInstance();
        LicenseManager instance2 = LicenseManager.getInstance();

        assertSame(instance1, instance2, "As instâncias devem ser iguais (Singleton)");
    }

    @Test
    public void testInitialLicenseKey() {
        // Verificar se a chave de licença inicial está correta
        LicenseManager licenseManager = LicenseManager.getInstance();

        assertEquals("ABCD-1234-EFGH-5678", licenseManager.getLicenseKey(), "A chave de licença inicial deve ser 'ABCD-1234-EFGH-5678'");
    }

    @Test
    public void testInitialLicenseValidity() {
        // Verificar se a licença inicial é válida
        LicenseManager licenseManager = LicenseManager.getInstance();

        assertTrue(licenseManager.isLicenseValid(), "A licença inicial deve ser válida");
    }

    @Test
    public void testUpdateLicenseKey() {
        // Testar a atualização da chave de licença e validar
        LicenseManager licenseManager = LicenseManager.getInstance();
        String newKey = "WXYZ-9876-IJKL-5432";

        licenseManager.updateLicenseKey(newKey);

        assertEquals(newKey, licenseManager.getLicenseKey(), "A chave de licença deve ser atualizada para 'WXYZ-9876-IJKL-5432'");
        assertTrue(licenseManager.isLicenseValid(), "A nova chave de licença deve ser válida");
    }

    @Test
    public void testInvalidLicenseKey() {
        // Testar a atualização com uma chave de licença inválida
        LicenseManager licenseManager = LicenseManager.getInstance();
        String invalidKey = "INVALID-KEY";

        licenseManager.updateLicenseKey(invalidKey);

        assertEquals(invalidKey, licenseManager.getLicenseKey(), "A chave de licença deve ser atualizada para 'INVALID-KEY'");
        assertFalse(licenseManager.isLicenseValid(), "A nova chave de licença deve ser inválida");
    }
}
