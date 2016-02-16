package br.edu.ifpb.pos.service.dominio.util;

import java.security.MessageDigest;
import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class GenerateCodeUtils {

    /**
     * Gera um código Hash a partir dos parâmetros passados.
     * @param prefix String adicionado no início do código, não muda e não é
     * considerada na geração do Hash
     * @param length tamanho do código que será gerado (considerando o prefixo)
     * @param args são os objetos que serão usados para gerar o Hash
     */
    public static String generateCode(String prefix, int length, Object... args) {
        if (prefix == null && prefix.trim().isEmpty()) {
            throw new InvalidParameterException();
        }
        if (!(length - prefix.length() >= 4 && length <= 40 + prefix.length())) {
            throw new InvalidParameterException();
        }
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA1");
            String toDigest = Arrays.toString(args);
            byte[] messageDigest = algorithm.digest(toDigest.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            hexString.append(prefix.toUpperCase());
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            return hexString.toString().substring(0, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
