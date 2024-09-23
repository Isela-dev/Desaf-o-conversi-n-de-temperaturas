import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusAFahrenheitConverter {
    public static void main(String[] args) {
        // Crear el marco para el cambio de temperatura
        JFrame frame = new JFrame("Convertidor Celsius a Fahrenheit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Crear el panel de temperatura
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Hacer el marco visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel celsiusLabel = new JLabel("Temperatura en Celsius:");
        celsiusLabel.setBounds(10, 20, 200, 25);
        panel.add(celsiusLabel);

        JTextField celsiusText = new JTextField(20);
        celsiusText.setBounds(200, 20, 165, 25);
        panel.add(celsiusText);

        JButton convertButton = new JButton("Convertir");
        convertButton.setBounds(10, 80, 150, 25);
        panel.add(convertButton);

        JLabel fahrenheitLabel = new JLabel("Temperatura en Fahrenheit:");
        fahrenheitLabel.setBounds(10, 110, 200, 25);
        panel.add(fahrenheitLabel);

        JTextField fahrenheitText = new JTextField(20);
        fahrenheitText.setBounds(200, 110, 165, 25);
        fahrenheitText.setEditable(false); // Solo lectura
        panel.add(fahrenheitText);

        // Acción del botón
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(celsiusText.getText());
                    int fahrenheit = (int) ((celsius * 1.8) + 32); // Convertir a Fahrenheit sin decimales
                    fahrenheitText.setText(String.valueOf(fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Por favor, ingresa un número válido.");
                }
            }
        });
    }
}
