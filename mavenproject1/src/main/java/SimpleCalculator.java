import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SimpleCalculator extends JFrame {

    private JTextField txtso01, txtso02, txtKetQua;
    private JButton btnCong, btnTru, btnNhan, btnChia;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        JPanel panelInput = new JPanel(new GridLayout(3, 2));
        JPanel panelButtons = new JPanel(new FlowLayout());
        JPanel panelResult = new JPanel(new BorderLayout());
       

        JLabel lblso01 = new JLabel("So thu 1:");
        JLabel lblso02 = new JLabel("So thu 2:");
        JLabel lblKetQua = new JLabel("Ket Qua:");
       
        txtso01 = new JTextField(10);
        txtso02 = new JTextField(10);
        txtKetQua = new JTextField(10);
        txtKetQua.setEditable(false);  // Không cho phép chỉnh sửa

        panelInput.add(lblso01);
        panelInput.add(txtso01);
        panelInput.add(lblso02);
        panelInput.add(txtso02);
        panelInput.add(lblKetQua);
        panelInput.add(txtKetQua);
       
        // Tạob nút bấm
        btnCong = new JButton("Cong");
        btnTru = new JButton("Tru");
        btnNhan = new JButton("Nhan");
        btnChia = new JButton("Chia");
       
        // Thêm nút bấm
        panelButtons.add(btnCong);
        panelButtons.add(btnTru);
        panelButtons.add(btnNhan);
        panelButtons.add(btnChia);
       
        // panelInput,panelButtons
        add(panelInput, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
       //btn
        btnCong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('+');
            }
        });
       
        btnTru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('-');
            }
        });
       
        btnNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('*');
            }
        });
       
        btnChia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('/');
            }
        });
    }

    // Phương thức tính
    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(txtso01.getText());
            double num2 = Double.parseDouble(txtso02.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Khong the chia cho 0!");
                        return;
                    }
                    break;
            }

            // Hiển thị kết quả
            txtKetQua.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui long nhap so dung");
        }
    }

    public static void main(String[] args) {
        //run lol
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setVisible(true);
    }
}