import javax.swing.JOptionPane;

class NotStringException extends Exception {
    public NotStringException(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}