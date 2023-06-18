import Entity.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainApp extends JFrame{
    private JPanel mainPanel;
    private JButton chooseBtn;
    private JButton nextBtn;
    private JButton prevBtn;
    private JLabel lbName;
    private JLabel lbBrand;
    private JLabel lbTest;
    private int currPage = 0;


    public MainApp(String title, Dimension dimension) {
        setTitle(title);
        setSize(dimension);

        registerListeners();


        loadCars();

    }

    private void registerListeners() {
        chooseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Vyber soubor");
                int res = chooser.showDialog(mainPanel,"Vyber");
                if(res == JFileChooser.CANCEL_OPTION) {
                    Logger.Warning("Nebyl vybrán žádný soubor!");
                }else if(res == JFileChooser.ERROR) {
                    Logger.Error("Chyba");
                }else if(res == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    Logger.Info(file.getName());
                }
            }
        });

        prevBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currPage == 0) {
                    currPage = Main.getCars().size() -1;
                }else if(currPage >= 1) {
                    currPage--;
                }
                loadCars();
            }
        });
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Main.getCars().size()-1 > currPage) {
                    currPage++;
                }else {
                    currPage = 0;
                }
                loadCars();
            }
        });
    }

    public void init() {
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void loadCars() {
        System.out.println(currPage);
        Car car = Main.getCars().get(currPage);
        lbName.setText(car.getName());
        lbBrand.setText(car.getBrand());
        lbTest.setText(String.valueOf(car.getTest()));
    }

}
