import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 중간고사 계산기 만들기
 */
public class MidTermCalc extends JFrame {
    JTextField text = new JTextField();

    /**
     * 계산기
     */
    MidTermCalc() {
        setTitle("계산기");

        setLayout(new BorderLayout());
        showNorth(); showCenter();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setVisible(true);
    }

    /**
     * 계산결과 표시
     */
    void showNorth() {
        JPanel panel = new JPanel();

        //숫자창
        text = new JTextField(25);
        text.setEditable(false);
        panel.setBackground(Color.darkGray);

        panel.add(text);


        add(panel, BorderLayout.NORTH);
    }
    void showCenter() {
        JPanel panel = new JPanel(new GridLayout(5,4));

        panel.setSize(2, 300);

        //넘버패드 숫자키 부분
        JButton num0 = new JButton("0");
        JButton num1 = new JButton("1");
        JButton num2 = new JButton("2");
        JButton num3 = new JButton("3");
        JButton num4 = new JButton("4");
        JButton num5 = new JButton("5");
        JButton num6 = new JButton("6");
        JButton num7 = new JButton("7");
        JButton num8 = new JButton("8");
        JButton num9 = new JButton("9");
        JButton signs = new JButton("+/-");
        JButton dot = new JButton(".");

        //넘버패드 연산자 부분
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("×");
        JButton divide = new JButton("÷");
        JButton remainder = new JButton("%");
        JButton equal = new JButton("=");
        JButton clear = new JButton("C");
        JButton delete = new JButton("←");

        //버튼 색깔 변경
        num0.setBackground(Color.GRAY); num0.setForeground(Color.WHITE);
        num1.setBackground(Color.GRAY); num1.setForeground(Color.WHITE);
        num2.setBackground(Color.GRAY); num2.setForeground(Color.WHITE);
        num3.setBackground(Color.GRAY); num3.setForeground(Color.WHITE);
        num4.setBackground(Color.GRAY); num4.setForeground(Color.WHITE);
        num5.setBackground(Color.GRAY); num5.setForeground(Color.WHITE);
        num6.setBackground(Color.GRAY); num6.setForeground(Color.WHITE);
        num7.setBackground(Color.GRAY); num7.setForeground(Color.WHITE);
        num8.setBackground(Color.GRAY); num8.setForeground(Color.WHITE);
        num9.setBackground(Color.GRAY); num9.setForeground(Color.WHITE);
        num0.setBackground(Color.GRAY); remainder.setForeground(Color.WHITE);
        signs.setBackground(Color.GRAY); signs.setForeground(Color.WHITE);
        dot.setBackground(Color.GRAY); dot.setForeground(Color.WHITE);

        plus.setBackground(Color.DARK_GRAY); plus.setForeground(Color.WHITE);
        minus.setBackground(Color.DARK_GRAY); minus.setForeground(Color.WHITE);
        multiply.setBackground(Color.DARK_GRAY); multiply.setForeground(Color.WHITE);
        divide.setBackground(Color.DARK_GRAY); divide.setForeground(Color.WHITE);
        remainder.setBackground(Color.DARK_GRAY); remainder.setForeground(Color.WHITE);
        equal.setBackground(Color.DARK_GRAY); equal.setForeground(Color.WHITE);
        clear.setBackground(Color.DARK_GRAY); clear.setForeground(Color.WHITE);
        delete.setBackground(Color.DARK_GRAY); delete.setForeground(Color.WHITE);




        panel.add(remainder); panel.add(clear); panel.add(divide); panel.add(delete);
        panel.add(num7); panel.add(num8); panel.add(num9); panel.add(multiply);
        panel.add(num4); panel.add(num5); panel.add(num6); panel.add(minus);
        panel.add(num1); panel.add(num2); panel.add(num3); panel.add(plus);
        panel.add(signs); panel.add(num0); panel.add(dot); panel.add(equal);


        add(panel, BorderLayout.CENTER);

        //결과창에 숫자를 추가하는 코드
        ActionListener listenerNumPad = e -> {text.setText(text.getText() + e.getActionCommand());};
        num0.addActionListener(listenerNumPad);
        num1.addActionListener(listenerNumPad);
        num2.addActionListener(listenerNumPad);
        num3.addActionListener(listenerNumPad);
        num4.addActionListener(listenerNumPad);
        num5.addActionListener(listenerNumPad);
        num6.addActionListener(listenerNumPad);
        num7.addActionListener(listenerNumPad);
        num8.addActionListener(listenerNumPad);
        num9.addActionListener(listenerNumPad);
        dot.addActionListener(listenerNumPad);

        // @see 부호 변환 chatGPT 참조
        ActionListener listenerChangeSign = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                if (!currentText.isEmpty()) {
                    if (currentText.startsWith("-")) {
                        text.setText(currentText.substring(1));  // 음수 -> 양수로 변경
                    } else {
                        text.setText("-" + currentText);  // 양수 -> 음수로 변경
                    }
                }
            }
        };
        signs.addActionListener(listenerChangeSign);

        // delete 버튼 구현
        ActionListener listenerDelete = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = text.getText();
                if (!currentText.isEmpty()) {
                    text.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        };
        delete.addActionListener(listenerDelete);

    }

    public static void main(String[] args) {
        new MidTermCalc();
    }
}
