import java.awt.*;
import javax.swing.*;

/**
 * 중간고사 계산기 만들기
 */
public class MidTermCalc extends JFrame {
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
        JTextField text = new JTextField(25);
        text.setText("0");
        text.setEditable(false);

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

        panel.add(remainder); panel.add(clear); panel.add(divide); panel.add(delete);
        panel.add(num7); panel.add(num8); panel.add(num9); panel.add(multiply);
        panel.add(num4); panel.add(num5); panel.add(num6); panel.add(minus);
        panel.add(num1); panel.add(num2); panel.add(num3); panel.add(plus);
        panel.add(signs); panel.add(num0); panel.add(dot); panel.add(equal);


        add(panel, BorderLayout.CENTER);


    }
    public static void main(String[] args) {
        new MidTermCalc();
    }
}
