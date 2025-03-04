@WebServlet("/InsecureTransferServlet")
public class InsecureTransferServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String beneficiary = request.getParameter("beneficiary");
        String amount = request.getParameter("amount");
        
        // Eseguo direttamente il trasferimento (fittizio)
        boolean result = BankAPI.transferFunds(getCurrentUser(request), beneficiary, amount);
        
        if (result) {
            response.getWriter().println("Trasferimento avvenuto con successo");
        } else {
            response.getWriter().println("Errore nel trasferimento");
        }
    }

    private String getCurrentUser(HttpServletRequest request) {
        // Recupera l'utente corrente dalla sessione (semplificato)
        return (String) request.getSession().getAttribute("username");
    }
}
