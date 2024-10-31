import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 중간고사 계산기 만들기
 */
public class MidTermCalc extends JFrame {
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    private String operator = "";  // 현재 선택된 연산자
    private double firstNumber = 0;  // 첫 번째 숫자 저장
    private double secondNumber = 0;

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
        JPanel panel = new JPanel(new GridLayout(2,1));
        //숫자창
        t1 = new JTextField(25);
        t2 = new JTextField(25);
        t1.setEditable(false);
        t2.setEditable(false);
        panel.setBackground(Color.darkGray);

        Font segoeUIFont = new Font("Segoe UI", Font.PLAIN, 24);

        t1.setFont(segoeUIFont);
        t2.setFont(segoeUIFont);
        t1.setHorizontalAlignment(JTextField.RIGHT);
        t2.setHorizontalAlignment(JTextField.RIGHT);

        panel.add(t2);
        panel.add(t1);



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

        // **Segoe UI 폰트 설정**
        Font buttonFont = new Font("Segoe UI", Font.PLAIN, 18);  // Segoe UI, 크기 18

        // 넘버패드 숫자키
        num0.setBackground(Color.GRAY); num0.setForeground(Color.WHITE); num0.setFont(buttonFont);
        num1.setBackground(Color.GRAY); num1.setForeground(Color.WHITE); num1.setFont(buttonFont);
        num2.setBackground(Color.GRAY); num2.setForeground(Color.WHITE); num2.setFont(buttonFont);
        num3.setBackground(Color.GRAY); num3.setForeground(Color.WHITE); num3.setFont(buttonFont);
        num4.setBackground(Color.GRAY); num4.setForeground(Color.WHITE); num4.setFont(buttonFont);
        num5.setBackground(Color.GRAY); num5.setForeground(Color.WHITE); num5.setFont(buttonFont);
        num6.setBackground(Color.GRAY); num6.setForeground(Color.WHITE); num6.setFont(buttonFont);
        num7.setBackground(Color.GRAY); num7.setForeground(Color.WHITE); num7.setFont(buttonFont);
        num8.setBackground(Color.GRAY); num8.setForeground(Color.WHITE); num8.setFont(buttonFont);
        num9.setBackground(Color.GRAY); num9.setForeground(Color.WHITE); num9.setFont(buttonFont);
        // 부호 소수점
        signs.setBackground(Color.GRAY); signs.setForeground(Color.WHITE); signs.setFont(buttonFont);
        dot.setBackground(Color.GRAY); dot.setForeground(Color.WHITE); dot.setFont(buttonFont);

        // 넘버패드 연산자
        plus.setBackground(Color.DARK_GRAY); plus.setForeground(Color.WHITE); plus.setFont(buttonFont);
        minus.setBackground(Color.DARK_GRAY); minus.setForeground(Color.WHITE); minus.setFont(buttonFont);
        multiply.setBackground(Color.DARK_GRAY); multiply.setForeground(Color.WHITE); multiply.setFont(buttonFont);
        divide.setBackground(Color.DARK_GRAY); divide.setForeground(Color.WHITE); divide.setFont(buttonFont);
        remainder.setBackground(Color.DARK_GRAY); remainder.setForeground(Color.WHITE); remainder.setFont(buttonFont);
        // 결과 및 기능
        equal.setBackground(Color.DARK_GRAY); equal.setForeground(Color.WHITE); equal.setFont(buttonFont);
        clear.setBackground(Color.DARK_GRAY); clear.setForeground(Color.WHITE); clear.setFont(buttonFont);
        delete.setBackground(Color.DARK_GRAY); delete.setForeground(Color.WHITE); delete.setFont(buttonFont);




        panel.add(remainder); panel.add(clear); panel.add(divide); panel.add(delete);
        panel.add(num7); panel.add(num8); panel.add(num9); panel.add(multiply);
        panel.add(num4); panel.add(num5); panel.add(num6); panel.add(minus);
        panel.add(num1); panel.add(num2); panel.add(num3); panel.add(plus);
        panel.add(signs); panel.add(num0); panel.add(dot); panel.add(equal);


        add(panel, BorderLayout.CENTER);

        //결과창에 숫자를 추가하는 코드
        ActionListener listenerNumPad = e -> {
            t1.setText(t1.getText() + e.getActionCommand());
            firstNumber = Double.parseDouble(t1.getText());
        };
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

        //부호 변환
        /**
         * @see chatGPT 참조
          */
        ActionListener listenerChangeSign = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = t1.getText();
                if (!currentText.isEmpty()) {
                    if (currentText.startsWith("-")) {
                        t1.setText(currentText.substring(1));  // 음수 -> 양수로 변경
                    } else {
                        t1.setText("-" + currentText);  // 양수 -> 음수로 변경
                    }
                }
            }
        };
        signs.addActionListener(listenerChangeSign);

        // delete 버튼 구현
        ActionListener listenerDelete = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = t1.getText();
                if (!currentText.isEmpty()) {
                    t1.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        };
        delete.addActionListener(listenerDelete);


        //연산 기능 구현
        ActionListener listenerOperator = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = e.getActionCommand();
                if (t2.getText().isEmpty()) {
                    secondNumber = firstNumber;
                }
                t2.setText(secondNumber + operator);
                t1.setText(null);

            }
        };

        plus.addActionListener(listenerOperator);
        minus.addActionListener(listenerOperator);
        multiply.addActionListener(listenerOperator);
        divide.addActionListener(listenerOperator);

        //클리어 기능 구현
        ActionListener listenerClear = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText(null);
                t2.setText(null);
                firstNumber = 0; secondNumber = 0;
            }
        };
        clear.addActionListener(listenerClear);

        //결과 기능 구현
        ActionListener listenerEqual = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t2.setText(secondNumber + operator + firstNumber);
                double result;
                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "×":
                        result = firstNumber * secondNumber;
                        break;
                    case "÷":
                        if (secondNumber == 0) {
                            t1.setText("오류");  // 0으로 나누기 방지
                            return;
                        }
                        result = firstNumber / secondNumber;
                        break;
                    case "%":
                        result = firstNumber % secondNumber;
                        break;
                    default:
                        result = secondNumber;
                }
                t1.setText(Double.toString(result));
            }
        };
        equal.addActionListener(listenerEqual);
    }


    public static void main(String[] args) {
        new MidTermCalc();
    }
}
