import javax.swing.JOptionPane;

class NotIntegerException extends Exception {
    public NotIntegerException(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}