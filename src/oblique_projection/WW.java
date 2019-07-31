package oblique_projection;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WW extends JFrame implements ActionListener {
// v0- initial velocity, a- shot angle, g -gravity

    protected static JPanel ppanel,
            pcurve,
            pscale,
            pLine;
    protected static JLabel lv0, la, lg,
            lv0Unit, laUnit, lgUnit,
            lLength, lHeight, lTime,
            lComment, lLegend,
            ll, lh, lt;
    protected static JTextField tv0, ta, tg;
    protected static JButton bDraw, bClear;

    WW() {
        this.setTitle("rzut ukosny");
        this.setBounds(0, 0, 700, 600);
        this.setDefaultCloseOperation(WW.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);

        ppanel = new JPanel();
        ppanel.setBounds(0, 0, 700, 600);
        ppanel.setVisible(true);
        ppanel.setLayout(null);
        ppanel.setBackground(new Color(150, 200, 255));
        this.add(ppanel);

        lv0 = new JLabel();
        lv0.setBounds(50, 50, 50, 50);
        lv0.setVisible(true);
        lv0.setText("v0");
        ppanel.add(lv0);

        tv0 = new JTextField();
        tv0.setText("20");
        tv0.setBounds(100, 50, 100, 50);
        tv0.setVisible(true);
        ppanel.add(tv0);

        lv0Unit = new JLabel();
        lv0Unit.setBounds(250, 50, 50, 50);
        lv0Unit.setVisible(true);
        lv0Unit.setText("m/s");
        ppanel.add(lv0Unit);

        la = new JLabel();
        la.setBounds(50, 100, 50, 50);
        la.setVisible(true);
        la.setText("a");
        ppanel.add(la);

        ta = new JTextField();
        ta.setText("30");
        ta.setBounds(100, 100, 100, 50);
        ta.setVisible(true);
        ppanel.add(ta);

        laUnit = new JLabel();
        laUnit.setBounds(250, 100, 50, 50);
        laUnit.setVisible(true);
        laUnit.setText("stopnie");
        ppanel.add(laUnit);

        lg = new JLabel();
        lg.setBounds(50, 150, 50, 50);
        lg.setVisible(true);
        lg.setText("g");
        ppanel.add(lg);

        tg = new JTextField();
        tg.setText("9.8");
        tg.setBounds(100, 150, 100, 50);
        tg.setVisible(true);
        ppanel.add(tg);

        lgUnit = new JLabel();
        lgUnit.setBounds(250, 150, 50, 50);
        lgUnit.setVisible(true);
        lgUnit.setText("m/s^2");
        ppanel.add(lgUnit);

        lComment = new JLabel();
        lComment.setBounds(50, 250, 150, 100);
        lComment.setVisible(true);
        lComment.setText("pole komentarzy");
        ppanel.add(lComment);

        bDraw = new JButton();
        bDraw.setText("rysuj");
        bDraw.setBounds(25, 400, 100, 50);
        bDraw.setVisible(true);
        bDraw.addActionListener(this);
        ppanel.add(bDraw);

        bClear = new JButton();
        bClear.setText("czysc");
        bClear.setBounds(225, 400, 100, 50);
        bClear.setVisible(true);
        bClear.addActionListener(this);
        ppanel.add(bClear);

        pcurve = new JPanel();
        pcurve.setBounds(350, 50, 300, 300);
        pcurve.setVisible(true);
        pcurve.setLayout(null);
        pcurve.setBackground(Color.WHITE);
        ppanel.add(pcurve);

        pscale = new JPanel();
        pscale.setBounds(0, 0, 299, 299);
        pscale.setVisible(true);
        pscale.setLayout(null);
        pscale.setBackground(new Color(255, 255, 255, 0));
        pcurve.add(pscale);

        lLegend = new JLabel();
        lLegend.setBounds(450, 350, 200, 50);
        lLegend.setVisible(true);
        lLegend.setText("LEGENDA: jedna kratka= 1m^2");
        ppanel.add(lLegend);

        pLine = new JPanel();
        pLine.setBounds(330, 10, 5, 540);
        pLine.setVisible(true);
        pLine.setBackground(Color.blue);
        ppanel.add(pLine);

        lLength = new JLabel();
        lLength.setBounds(350, 450, 100, 25);
        lLength.setVisible(true);
        lLength.setText("dlugosc [m]");
        ppanel.add(lLength);

        lHeight = new JLabel();
        lHeight.setBounds(450, 450, 100, 25);
        lHeight.setVisible(true);
        lHeight.setText("wysokosc [m]");
        ppanel.add(lHeight);

        lTime = new JLabel();
        lTime.setBounds(550, 450, 100, 25);
        lTime.setVisible(true);
        lTime.setText("czas [s]");
        ppanel.add(lTime);

        ll = new JLabel();
        ll.setBounds(350, 470, 100, 25);
        ll.setVisible(true);
        ll.setText("--");
        ppanel.add(ll);

        lh = new JLabel();
        lh.setBounds(450, 470, 100, 25);
        lh.setVisible(true);
        lh.setText("--");
        ppanel.add(lh);

        lt = new JLabel();
        lt.setBounds(550, 470, 100, 25);
        lt.setVisible(true);
        lt.setText("--");
        ppanel.add(lt);

        this.repaint();
        ppanel.repaint();
        pcurve.repaint();
        pscale.repaint();

    }

    ;
    
    public static void main(String[] args) {
        WW okno = new WW();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bDraw) {
            Checking.check();
            ll.setText(String.format("%.2f", Calculations.l(Checking.v0, Checking.a, Checking.g)));
            lh.setText(String.format("%.2f", Calculations.h(Checking.v0, Checking.a, Checking.g)));
            lt.setText(String.format("%.2f", Calculations.t(Checking.v0, Checking.a, Checking.g)));

            Drawing.draw();
        } else if (ae.getSource() == bClear) {
            Graphics kredka = pcurve.getGraphics();
            kredka.setColor(Color.white);
            kredka.fillRect(0, 0, 300, 300);
            lComment.setText("pole komentarzy");
        }
    }
}
