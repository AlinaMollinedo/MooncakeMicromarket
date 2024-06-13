public class ValueChecker {
	public static void checkInt(Object value) throws NotIntegerException {
        if (!(value instanceof Integer)) {
            throw new NotIntegerException("El valor no es un número entero.");
        }
    }

    public static void checkString(Object value) throws NotStringException {
        if (!(value instanceof String)) {
            throw new NotStringException("El valor no es una cadena de texto.");
        }
    }
    
    public static void checkMaxLength(String value, int maxLength) throws InvalidStringLengthException {
        if (value.length() > maxLength) {
            throw new InvalidStringLengthException("El string excede la longitud máxima permitida de " + maxLength + " caracteres.");
        }
    }
}   