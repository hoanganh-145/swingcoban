import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBox extends JFrame implements ActionListener {
    private JTextField txtso01, txtso02, txtKetQua;
    private JComboBox<String> comboPhepTinh;
    private JButton btnCalculate, btnReset;

    public ComboBox() {
        setTitle("Calculator with JComboBox");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Tạo thành phần giao diện
        JLabel lblso01 = new JLabel("So thu 1:");
        JLabel lblso02 = new JLabel("So thu 2:");
        JLabel lblKetQua = new JLabel("Ket Qua:");

        txtso01 = new JTextField(10);
        txtso02 = new JTextField(10);
        txtKetQua = new JTextField(10);
        txtKetQua.setEditable(false);  // Không cho phép chỉnh sửa kết quả

        //JComboBox
        String[] operations = { "Cộng (+)", "Trừ (-)", "Nhân (*)", "Chia (/)" };
        comboPhepTinh = new JComboBox<>(operations);
        comboPhepTinh.setSelectedIndex(0);  // Đặt phép tính cộng làm mặc định

        // Tạo các nút tính toán và nhập lại
        btnCalculate = new JButton("Tính");
        btnReset = new JButton("Nhập lại");

        btnCalculate.addActionListener(this);
        btnReset.addActionListener(this);

        // Sắp xếp
        setLayout(new GridLayout(5, 2, 10, 10));
        add(lblso01);
        add(txtso01);
        add(lblso02);
        add(txtso02);
        add(new JLabel("Phep Tinh:"));
        add(comboPhepTinh);
        add(lblKetQua);
        add(txtKetQua);
        add(btnCalculate);
        add(btnReset);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            try {
                double num1 = Double.parseDouble(txtso01.getText());
                double num2 = Double.parseDouble(txtso02.getText());
                double result = 0;

                // Kiểm tra phép tính được chọn trong JComboBox
                String selectedOperation = (String) comboPhepTinh.getSelectedItem();
                if (selectedOperation.equals("Cộng (+)")) {
                    result = num1 + num2;
                } else if (selectedOperation.equals("Trừ (-)")) {
                    result = num1 - num2;
                } else if (selectedOperation.equals("Nhân (*)")) {
                    result = num1 * num2;
                } else if (selectedOperation.equals("Chia (/)")) {
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Khong the chia cho 0!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = num1 / num2;
                }

                txtKetQua.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui Long nhap so dung!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnReset) {
            // Xóa trắng dữ liệu và đặt lại phép tính cộng
            txtso01.setText("");
            txtso02.setText("");
            txtKetQua.setText("");
            comboPhepTinh.setSelectedIndex(0);  //cộng mặc định
            txtso01.requestFocus();  //focu
        }
    }

    public static void main(String[] args) {
        new ComboBox();
    }
}
