import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 중간고사 계산기 만들기
 */
public class MidTermCalc extends JFrame {
    JTextField t1 = new JTextField();
    JTextField screen1 = new JTextField();
    JTextField tFirstNum = new JTextField();
    JTextField tSeconNum = new JTextField();
    JTextField tOperator = new JTextField();
    private String operator = "";  // 현재 선택된 연산자
    private double firstNumber = 0;  // 첫 번째 숫자 저장
    private double secondNumber = 0;
    private int setNum = 0;

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
        JPanel panel = new JPanel(new GridLayout(1,2));
        JPanel p1 = new JPanel(new GridLayout(2,1));

        //JPanel p2 = new JPanel(new GridLayout(0,3));

        //숫자창
        t1 = new JTextField(25);
        screen1 = new JTextField(50);
        tFirstNum = new JTextField(25);
        tSeconNum = new JTextField(25);
        tOperator = new JTextField(25);

        t1.setEditable(false);
        screen1.setEditable(false);
        tFirstNum.setEditable(true);
        tSeconNum.setEditable(true);
        tOperator.setEditable(false);



        t1.setText("0");
        tFirstNum.setText("0");
        tSeconNum.setText("0");

        panel.setBackground(Color.darkGray);

        Font segoeUIFont = new Font("Segoe UI", Font.PLAIN, 24);

        t1.setFont(segoeUIFont); t1.setHorizontalAlignment(JTextField.RIGHT);
        screen1.setFont(segoeUIFont); screen1.setHorizontalAlignment(SwingConstants.RIGHT);



        tFirstNum.setFont(segoeUIFont);
        tFirstNum.setHorizontalAlignment(JTextField.RIGHT);
        tSeconNum.setFont(segoeUIFont);
        tSeconNum.setHorizontalAlignment(JTextField.RIGHT);
        tOperator.setFont(segoeUIFont);
        tOperator.setHorizontalAlignment(JTextField.RIGHT);

        p1.add(screen1); p1.add(t1);
        panel.add(p1);
        //p2.add(tFirstNum); p2.add(tOperator); p2.add(tSeconNum);
        //panel.add(p2);


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
        JButton ce = new JButton("CE");
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
        ce.setBackground(Color.DARK_GRAY); ce.setForeground(Color.WHITE); ce.setFont(buttonFont);
        // 결과 및 기능
        equal.setBackground(Color.DARK_GRAY); equal.setForeground(Color.WHITE); equal.setFont(buttonFont);
        clear.setBackground(Color.DARK_GRAY); clear.setForeground(Color.WHITE); clear.setFont(buttonFont);
        delete.setBackground(Color.DARK_GRAY); delete.setForeground(Color.WHITE); delete.setFont(buttonFont);




        panel.add(ce); panel.add(clear); panel.add(delete); panel.add(divide);
        panel.add(num7); panel.add(num8); panel.add(num9); panel.add(multiply);
        panel.add(num4); panel.add(num5); panel.add(num6); panel.add(minus);
        panel.add(num1); panel.add(num2); panel.add(num3); panel.add(plus);
        panel.add(signs); panel.add(num0); panel.add(dot); panel.add(equal);


        add(panel, BorderLayout.CENTER);

        //텍스트필드에 숫자를 추가하는 코드
        ActionListener listenerNumPad = e -> {
            if (setNum ==3) {
                t1.setText("0");
                screen1.setText("");
                setNum = 0;
            }
            if (setNum == 1) {
                t1.setText("");
                setNum = 2;
            }
            if (setNum == 4) {
                t1.setText("0");
                setNum = 2;
            }

            String currentNum = e.getActionCommand();
            String currentText = t1.getText();
            if (currentText.equals("0") || currentText.equals("0.0")) {
                currentText = "";
                if (currentNum.equals(".")){
                    currentText = "0";
                }
            }
            t1.setText(currentText + currentNum);

            if(setNum == 2) {
                tSeconNum.setText(t1.getText());
            } else {
                tFirstNum.setText(t1.getText());
            }
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
        ActionListener listenerChangeSign = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (setNum == 1 || setNum == 4) {setNum = 2;}
                if (setNum == 2) {
                    secondNumber = Double.parseDouble(t1.getText());
                    secondNumber = secondNumber * -1;
                    tSeconNum.setText(String.valueOf(secondNumber));
                } else {
                    firstNumber = Double.parseDouble(t1.getText());
                    firstNumber = firstNumber * -1;
                    tFirstNum.setText(String.valueOf(firstNumber));
                }

                if (setNum == 2) {
                    t1.setText(tSeconNum.getText());
                } else {
                    t1.setText(tFirstNum.getText());
                }
            };
        };
        signs.addActionListener(listenerChangeSign);

        // (delete 버튼) 구현
        ActionListener listenerDelete = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (setNum == 1 || setNum == 4) {setNum = 2;}
                if (setNum == 3) {
                    screen1.setText("");
                } else {
                    String currentText = t1.getText();
                    if (!currentText.isEmpty()) {
                        t1.setText(currentText.substring(0, currentText.length() - 1));
                        currentText = t1.getText();
                        if (currentText.isEmpty()){
                            t1.setText("0");
                        }
                    }
                    else {t1.setText("0");}


                    if (setNum == 2) {
                        tSeconNum.setText(t1.getText());
                    } else {
                        tFirstNum.setText(t1.getText());
                    }
                }
        }

        };
        delete.addActionListener(listenerDelete);


        //연산자 선택
        ActionListener listenerOperator = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = t1.getText();
                double currentNum = Double.parseDouble(currentText);
                tSeconNum.setText(String.valueOf(currentNum));

                if (setNum == 2) {
                    setNum = 1;
                }
                if (setNum == 3) {
                    setNum = 4;
                }

                if(setNum == 0){
                    tFirstNum.setText(currentText);
                    setNum =1;
                }
                {
                    operator = e.getActionCommand();
                    tOperator.setText(operator);
                    screen1.setText(tFirstNum.getText() + tOperator.getText());
                }

            }
        };

        plus.addActionListener(listenerOperator);
        minus.addActionListener(listenerOperator);
        multiply.addActionListener(listenerOperator);
        divide.addActionListener(listenerOperator);

        //(C 버튼) 기능 구현
        ActionListener listenerClearAll = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("0");
                screen1.setText("");
                tFirstNum.setText("0");
                tSeconNum.setText("0");
                tOperator.setText("");
                firstNumber = 0; secondNumber = 0; operator = ""; setNum = 0;
            }
        };
        clear.addActionListener(listenerClearAll);

        //(ce 버튼) 구현
        ActionListener listenerClear = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("0");

                if (setNum ==2){
                    tSeconNum.setText(t1.getText());
                } else {
                    tFirstNum.setText(t1.getText());
                }
            }
        };
        ce.addActionListener(listenerClear);

        //(= 버튼) 기능 구현
        ActionListener listenerEqual = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(tFirstNum.getText());
                secondNumber = Double.parseDouble(tSeconNum.getText());
                operator = tOperator.getText();
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
                    default:
                        result = Double.parseDouble(t1.getText());
                }
                //result 결과창에 출력
                screen1.setText(String.valueOf(firstNumber) + tOperator.getText() + tSeconNum.getText() + "=");
                t1.setText(String.valueOf(result));

                tFirstNum.setText(String.valueOf(result));
                setNum = 3;

            }
        };
        equal.addActionListener(listenerEqual);
    }


    public static void main(String[] args) {
        new MidTermCalc();
    }
}
