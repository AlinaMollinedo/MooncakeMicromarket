import javax.swing.JOptionPane;

class InvalidStringLengthException extends Exception {
    public InvalidStringLengthException(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}