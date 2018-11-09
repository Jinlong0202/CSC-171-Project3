import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FireWorksDemo extends JFrame implements ActionListener, ChangeListener, ItemListener {
        int endX, endY;
        int startX, startY;
        int instantX, instantY;
        double angleInDegrees;
        double angleInRadians;
        double time;
        double velocity0;
        double g = 9.8;
        Color color;
        int colorChoice;
        JFrame frame = new JFrame();
        Canvas canvas = new Canvas();
        JButton buttonLaunch = new JButton("Launch");
        JLabel labelSpeed = new JLabel("Speed: 50");
        JLabel labelAngle = new JLabel("Angle(In Degrees): 45");
        JLabel labelStartX = new JLabel("Start X: ");
        JLabel labelStartY = new JLabel("Start Y: ");
        JLabel labelTimeDelay = new JLabel("Time Delay: ");
        JTextField textFieldStartX = new JTextField(10);
        JTextField textFieldStartY = new JTextField(10);
        JTextField textFieldTimeDelay = new JTextField(10);
        JSlider sliderAngle = new JSlider(0,90);
        JSlider sliderSpeed = new JSlider(0,100);
        String stringTime;
        String stringStartX;
        String stringStartY;

    public void test(){
        startX = 0;
        startY = 1000;
        angleInDegrees=60;
        velocity0 = 100;
        time = 15;
    }

    public FireWorksDemo(){

        frame.setTitle("Acme Fireworks Company");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        SubPanel subPanel1 = new SubPanel();
        frame.add(subPanel1, BorderLayout.WEST);
        frame.setVisible(true);
        pack();

    }

    public static void main(String[] args){
        FireWorksDemo fireWorksDemo = new FireWorksDemo();
        fireWorksDemo.test();
    }

    public class SubPanel extends JPanel implements ActionListener, ChangeListener, ItemListener {
        public SubPanel(){
            setLayout(new GridLayout(30,1));
            textFieldStartX.addActionListener(this);
            textFieldStartY.addActionListener(this);
            textFieldTimeDelay.addActionListener(this);
            buttonLaunch.addActionListener(this);
            sliderAngle.addChangeListener(this);
            sliderSpeed.addChangeListener(this);
            this.add(labelStartX);
            this.add(textFieldStartX);
            this.add(labelStartY);
            this.add(textFieldStartY);
            this.add(labelAngle);
            this.add(sliderAngle);
            this.add(labelSpeed);
            this.add(sliderSpeed);
            this.add(labelTimeDelay);
            this.add(textFieldTimeDelay);
            this.add(buttonLaunch);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(buttonLaunch)){
                canvas.repaint();
            }
            //Get the input Start X
            if(e.getSource().equals(textFieldStartX)){
                stringStartX = textFieldStartX.getText();
                startX = Integer.parseInt(stringStartX);
            }
            //Get the input Start Y
            if(e.getSource().equals(textFieldStartY)){
                stringStartY = textFieldStartY.getText();
                startY = Integer.parseInt(stringStartY);
            }
        }

        @Override
        public void itemStateChanged(ItemEvent e) {

        }

        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource().equals(sliderAngle)){
                labelAngle.setText("Angle(In Degrees): " + sliderAngle.getValue());
            }
            if(e.getSource().equals(sliderSpeed)){
                labelSpeed.setText("Speed: " + sliderSpeed.getValue());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    //Paint
    public class Canvas extends JComponent {
        //Constructor
        public Canvas(){
        }

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(color);//Set Color
            calculateEndX();
            calculateEndY();
            g.fillRect(0,0,2,getHeight());//To separate to parts
            for(instantX = startX; instantX <= endX; instantX = instantX + 1){
                //Use dots to draw a curve
                System.out.println(startX+ " " + startY + " " + endX + " " +endY);
                System.out.println(instantX+ " " + instantY);
                instantY = getInstantY(instantX);
                g.fillOval(instantX + startX-2,getHeight()-instantY+2,4,4);
            }
        }
    }


    //<<Calculation Process>>
    public void calculateEndX(){
        angleInRadians = Math.toRadians(angleInDegrees);
        endX = startX + (int) (Math.cos(angleInRadians) * velocity0 * time);
    }
    //<<Calculation Process>>
    public void calculateEndY(){
        angleInRadians = Math.toRadians(angleInDegrees);
        endY = startY + (int) (Math.sin(angleInRadians) * velocity0 * time - (0.5 * g * time * time));
    }
    //<<Calculation Process>>
    public int getInstantY(double instantX){
        double x,a,b,c,d,e,f;
        x = this.instantX;
        a = Math.tan(angleInRadians);//tanAngle
        b = x * a;//x*tanAngle
        c = g * x * x;//gx^2
        d = Math.cos(angleInRadians);//cosAngle
        e = velocity0 * d;//cosAngle*v
        f = e * e * 2;//2(v*cosAngle)^2
        instantY = (int)(b - c / f);//Plug all into the given equation
        return instantY;
    }
    //Set Color
    public void chooseColor(int colorChoice){
        if(colorChoice == '2'){
            color = Color.CYAN;
        }
        if(colorChoice == '9'){
            color = Color.RED;
        }
        if(colorChoice == '4'){
            color = Color.GRAY;
        }
        if(colorChoice == '5'){
            color = Color.GREEN;
        }
        if(colorChoice == '1'){
            color = Color.BLUE;
        }
        if(colorChoice == '6'){
            color = Color.LIGHT_GRAY;
        }
        if(colorChoice == '7'){
            color = Color.MAGENTA;
        }
        if(colorChoice == '0'){
            color = Color.YELLOW;
        }
        if(colorChoice == '3'){
            color = Color.DARK_GRAY;
        }
        if(colorChoice == '8'){
            color = Color.ORANGE;
        }

    }

}
