package lib;

public class TaxFunction {
    
    public static class TaxCalculationInfo {
        private int monthlySalary;
        private int otherMonthlyIncome;
        private int numberOfMonthWorking;
        private int deductible;
        private boolean isMarried;
        private int numberOfChildren;
        
        // Constructor
        public TaxCalculationInfo(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
            this.monthlySalary = monthlySalary;
            this.otherMonthlyIncome = otherMonthlyIncome;
            this.numberOfMonthWorking = numberOfMonthWorking;
            this.deductible = deductible;
            this.isMarried = isMarried;
            this.numberOfChildren = numberOfChildren;
        }
        
        // Getter methods
        public int getMonthlySalary() {
            return monthlySalary;
        }
        
        public int getOtherMonthlyIncome() {
            return otherMonthlyIncome;
        }
        
        public int getNumberOfMonthWorking() {
            return numberOfMonthWorking;
        }
        
        public int getDeductible() {
            return deductible;
        }
        
        public boolean isMarried() {
            return isMarried;
        }
        
        public int getNumberOfChildren() {
            return numberOfChildren;
        }
    }
    
    public static int calculateTax(TaxCalculationInfo taxInfo) {
        int tax = 0;
        int monthlySalary = taxInfo.getMonthlySalary();
        int otherMonthlyIncome = taxInfo.getOtherMonthlyIncome();
        int numberOfMonthWorking = taxInfo.getNumberOfMonthWorking();
        int deductible = taxInfo.getDeductible();
        boolean isMarried = taxInfo.isMarried();
        int numberOfChildren = taxInfo.getNumberOfChildren();
    
        // Validasi bulan kerja
        if (numberOfMonthWorking > 12) {
            throw new IllegalArgumentException("Number of month working cannot be more than 12");
        }
    
        // Validasi anak
        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }
    
        // Hitung beban pajak
        double taxableIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking - deductible;
        double taxableIncomeMarried = taxableIncome - (54000000 + 4500000 + (numberOfChildren * 1500000));
        double taxableIncomeSingle = taxableIncome - 54000000;
    
        // Hitung pajak
        if (isMarried) {
            tax = (int) Math.round(taxableIncomeMarried * 0.05);
        } else {
            tax = (int) Math.round(taxableIncomeSingle * 0.05);
        }
    
        if (tax < 0) {
            return 0;
        } else {
            return tax;
        }
    }
}