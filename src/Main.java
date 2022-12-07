import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        GameWindow gameWindow = new GameWindow();

    }
    public static class GameWindow extends JFrame implements ActionListener {

        private JButton bPierre, bFeuille, bCiseaux, fermerJeu; // crée les boutons de jeu des trois options

        private JTextField affichageJoueur, decisionAdversaire, zoneResultat;

        GameWindow(){ // crée la fenêtre de jeu

            ImageIcon pierreIcon = new ImageIcon("pierre.png"); // (c) Freepik
            ImageIcon feuilleIcon = new ImageIcon("feuille.png"); // (c) Pixel perfect
            ImageIcon ciseauxIcon = new ImageIcon ("ciseaux.png"); // (c) Freepik

            JLabel debutPartie = new JLabel("Choisissez votre arme pour le duel :");

            affichageJoueur = new JTextField(15);
            affichageJoueur.setEditable(false);

            decisionAdversaire = new JTextField(15);
            decisionAdversaire.setEditable(false);

            zoneResultat = new JTextField(15);
            zoneResultat.setEditable(false);

            bPierre = new JButton("Pierre");
            bPierre.addActionListener(this);
            bPierre.setIcon(pierreIcon);
            bPierre.setHorizontalTextPosition(JButton.CENTER);
            bPierre.setVerticalTextPosition(JButton.BOTTOM);
            bPierre.setFont(new Font("Calibri",Font.BOLD,14));
            bPierre.setBorder(BorderFactory.createEtchedBorder());

            bFeuille = new JButton("Feuille");
            bFeuille.addActionListener(this);
            bFeuille.setIcon(feuilleIcon);
            bFeuille.setHorizontalTextPosition(JButton.CENTER);
            bFeuille.setVerticalTextPosition(JButton.BOTTOM);
            bFeuille.setFont(new Font("Calibri",Font.BOLD,14));
            bFeuille.setBorder(BorderFactory.createEtchedBorder());

            bCiseaux = new JButton("Ciseaux");
            bCiseaux.addActionListener(this);
            bCiseaux.setIcon(ciseauxIcon);
            bCiseaux.setHorizontalTextPosition(JButton.CENTER);
            bCiseaux.setVerticalTextPosition(JButton.BOTTOM);
            bCiseaux.setFont(new Font("Calibri",Font.BOLD,14));
            bCiseaux.setBorder(BorderFactory.createEtchedBorder());

            fermerJeu = new JButton("Quitter le jeu");
            fermerJeu.addActionListener(this);

            this.setTitle("Shifumi !");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(275,265);
            this.setVisible(true);

            this.add(debutPartie);
            this.add(bPierre);
            this.add(bFeuille);
            this.add(bCiseaux);
            this.add(affichageJoueur);
            this.add(decisionAdversaire);
            this.add(zoneResultat);
            this.add(fermerJeu);

            this.setLayout(new FlowLayout());
            this.setLocationRelativeTo(null);
            this.setResizable(false);

        }


        @Override //Définit les choix du joueur et de l'ordinateur
        public void actionPerformed(ActionEvent e) {

            int choixJoueur = 0;
            int choixOrdinateur;

            Random aleaOrdi = new Random();

            // stocke et affiche le choix du joueur
            if(e.getSource()==bPierre){
                choixJoueur = 0;
                affichageJoueur.setText("Vous avez choisi Pierre!");
            }
            else if(e.getSource()==bFeuille){
                choixJoueur = 1;
                affichageJoueur.setText("Vous avez choisi Feuille!");
            }
            else if(e.getSource()==bCiseaux){
                choixJoueur = 2;
                affichageJoueur.setText("Vous avez choisi Ciseaux!");
            }
            else {
                this.dispose();
            }

            // détermine le choix de l'ordinateur
            choixOrdinateur = aleaOrdi.nextInt(3);

            // permet d'indiquer le choix de l'ordinateur
            if (choixOrdinateur == 0){
                decisionAdversaire.setText("L'ordinateur choisit Pierre!");
            }
            else if (choixOrdinateur == 1){
                decisionAdversaire.setText("L'ordinateur choisit Feuille!");
            }
            else {
                decisionAdversaire.setText("L'ordinateur choisit Ciseaux!");
            }

            // détermine le résultat et l'affiche
            if (choixJoueur == choixOrdinateur){
                zoneResultat.setText("Match nul!");
            }
            else if ((choixJoueur == 0 && choixOrdinateur == 1)||
                    (choixJoueur == 1 && choixOrdinateur == 2)||
                    (choixJoueur == 2 && choixOrdinateur == 0)){
                zoneResultat.setText("Défaite!");
            }
            else {
                zoneResultat.setText("Victoire!");
            }
        }
    }
}