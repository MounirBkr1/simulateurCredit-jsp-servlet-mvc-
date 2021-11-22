package web;

import metier.CreditMetier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControleurServlet")
public class ControleurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CreditMetier metier;

    public ControleurServlet() {
        super();

    }

    @Override
    public void init() throws ServletException {
        metier = new CreditMetier();
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //une fois JSP affichée;les données par defaut qui s'affiche(des  zeros) dans les champs de saisie
        //éviter aussi probleme d'initiation d'objet CreditModel
        request.setAttribute("mod",new CreditModel());
        this.getServletContext().getRequestDispatcher("/VueCredit.jsp").forward(request, response);


    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //lire les données saisiees dans la vue
        double montant=Double.parseDouble(request.getParameter("montant"));
        double taux=Double.parseDouble(request.getParameter("taux"));
        int duree=Integer.parseInt(request.getParameter("duree"));

        //modifier les donées
        CreditModel model = new CreditModel();
        model.setMontant(montant);
        model.setTaux(taux);
        model.setDuree(duree);

        //appel a couche Metier pr faire les calcul
        double  res= metier.calculMensualite(montant, duree,taux);
        model.setMensualite(res);

        //stoquer le model dans l'objet request; pr qu'on puisse l'appeler a partir du jsp
        request.setAttribute("mod",model);
        this.getServletContext().getRequestDispatcher("/VueCredit.jsp").forward(request, response);


    }

}
