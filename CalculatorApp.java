import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField displayField;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public CalculatorApp() {
        // Cấu hình cửa sổ (Frame)
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Màn hình hiển thị
        displayField = new JTextField();
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        add(displayField, BorderLayout.NORTH);

        // Bảng chứa các nút bấm
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        // Mảng các nút
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        // Khởi tạo và thêm nút vào Panel
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null); // Hiển thị ở giữa màn hình
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Nếu bấm số
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            displayField.setText(displayField.getText() + command);
        } 
        // Nếu bấm nút xóa
        else if (command.equals("C")) {
            displayField.setText("");
            num1 = num2 = result = 0;
        } 
        // Nếu bấm dấu bằng
        else if (command.equals("=")) {
            if (!displayField.getText().isEmpty()) {
                num2 = Double.parseDouble(displayField.getText());
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/': 
                        if (num2 == 0) {
                            displayField.setText("Lỗi chia 0");
                            return;
                        }
                        result = num1 / num2; 
                        break;
                }
                // Hiển thị kết quả (bỏ số thập phân .0 nếu là số nguyên)
                if (result == (long) result) {
                    displayField.setText(String.format("%d", (long) result));
                } else {
                    displayField.setText(String.valueOf(result));
                }
                num1 = result;
            }
        } 
        // Nếu bấm các toán tử (+, -, *, /)
        else {
            if (!displayField.getText().isEmpty()) {
                num1 = Double.parseDouble(displayField.getText());
                operator = command.charAt(0);
                displayField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        // Chạy ứng dụng giao diện
        SwingUtilities.invokeLater(() -> new CalculatorApp());
    }
}