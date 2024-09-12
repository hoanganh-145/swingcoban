import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemoJRadioButton extends JFrame implements ActionListener {
    private JTextField txtso01, txtso02, txtKetQua;
    private JRadioButton rbtnAdd, rbtnSubtract, rbtnMultiply, rbtnDivide;
    private JButton btnCalculate, btnReset;
    private ButtonGroup operationGroup;

    public DemoJRadioButton() {
        
        setTitle("Radio button");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       
        JLabel lblso01 = new JLabel("so thu 1:");
        JLabel lblso02 = new JLabel("so thu 2:");
        JLabel lblKetQua = new JLabel("Ket Qua:");

        txtso01 = new JTextField(10);
        txtso02 = new JTextField(10);
        txtKetQua = new JTextField(10);
        txtKetQua.setEditable(false);

       
        rbtnAdd = new JRadioButton("Cộng (+)");
        rbtnSubtract = new JRadioButton("Trừ (-)");
        rbtnMultiply = new JRadioButton("Nhân (*)");
        rbtnDivide = new JRadioButton("Chia (/)");

       
        rbtnAdd.setSelected(true);

       
        operationGroup = new ButtonGroup();
        operationGroup.add(rbtnAdd);
        operationGroup.add(rbtnSubtract);
        operationGroup.add(rbtnMultiply);
        operationGroup.add(rbtnDivide);

       
        btnCalculate = new JButton("Tính");
        btnReset = new JButton("Nhập lại");

        btnCalculate.addActionListener(this);
        btnReset.addActionListener(this);

        
        setLayout(new GridLayout(6, 2, 10, 10));
        add(lblso01);
        add(txtso01);
        add(lblso02);
        add(txtso02);

        
        JPanel panelOperations = new JPanel(new FlowLayout());
        panelOperations.add(rbtnAdd);
        panelOperations.add(rbtnSubtract);
        panelOperations.add(rbtnMultiply);
        panelOperations.add(rbtnDivide);

        add(panelOperations);

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

                // Kiểm tra phép tính được chọn
                if (rbtnAdd.isSelected()) {
                    result = num1 + num2;
                } else if (rbtnSubtract.isSelected()) {
                    result = num1 - num2;
                } else if (rbtnMultiply.isSelected()) {
                    result = num1 * num2;
                } else if (rbtnDivide.isSelected()) {
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Khong the chia cho 0!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = num1 / num2;
                }

                txtKetQua.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui long nhap dung so!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnReset) {
            
            txtso01.setText("");
            txtso02.setText("");
            txtKetQua.setText("");
            rbtnAdd.setSelected(true); 
            txtso01.requestFocus(); 
        }
    }

    public static void main(String[] args) {
        new DemoJRadioButton();
    }
}
