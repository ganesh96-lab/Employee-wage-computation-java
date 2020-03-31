public class EmpWageComputation {
	//CONSTANTS
	public static final int IS_PART_TIME = 0;
	public static final int IS_FULL_TIME = 1;
	public static int EMP_RATE_PER_HRS;
	public static int MAX_WORKING_DAYS;
	public static int MAX_HRS_IN_MONTH;
	public static int TOTAL_EMP_WAGE;

	//CONSTRUCTOR
	public EmpWageComputation(int EMP_RATE_PER_HRS, int MAX_WORKING_DAYS, int MAX_HRS_IN_MONTH )	
	{
		this.EMP_RATE_PER_HRS = EMP_RATE_PER_HRS;
		this.MAX_WORKING_DAYS = MAX_WORKING_DAYS;
		this.MAX_HRS_IN_MONTH = MAX_HRS_IN_MONTH;
	}
	//getter methods
	public static int getEmpRatePerHrs()
	{
		return EMP_RATE_PER_HRS;
	}

	public static int getMaxWorkingDays()
	{
		return MAX_WORKING_DAYS;
	}

	public static int getMaxHrsInMonth()
	{
		return MAX_HRS_IN_MONTH;
	}

	public static int calEmpWages()
	{
		//variables
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;

		while( totalEmpHrs <= getMaxHrsInMonth() &&
				totalWorkingDays < getMaxWorkingDays() )  {
			totalWorkingDays++;
			int empCheck = (int) ( Math.random() * 10 ) % 3;
			switch (empCheck) {
				case IS_PART_TIME:
					empHrs = 4;
					break;
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				default:
					empHrs = 0;
			}
			//calculate total emp hrs
			totalEmpHrs += empHrs;
			//print daily many work hours 
			System.out.println("Day: " + totalWorkingDays + " Emp Hr: " +  empHrs);
		}
		// calculate total Wages
		TOTAL_EMP_WAGE = totalEmpHrs * getEmpRatePerHrs();
		return TOTAL_EMP_WAGE;	
	}

	public static void main(String args[])
	{
		EmpWageComputation bridgelabz = new EmpWageComputation(20, 20, 100 );
		int wage1 = bridgelabz.calEmpWages();
		System.out.println("TOTAL EMP WAGE FOR BRIDGELABZ : "+wage1);
		EmpWageComputation capgminai= new EmpWageComputation(50, 15, 75 );
		int wage2=capgminai.calEmpWages();
		System.out.println("TOTAL EMP WAGE FOR CAPGMINI : "+wage2);
	}
}