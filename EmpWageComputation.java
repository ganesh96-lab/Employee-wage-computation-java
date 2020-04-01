import java.util.ArrayList;
interface WageComputable
{
	public void calEmpWages(CompanyEmpWage companyObj);
}

public class EmpWageComputation implements WageComputable
{
	//CONSTANTS
	public final int IS_PART_TIME = 0;
	public final int IS_FULL_TIME = 1;
	
	ArrayList<Integer> empDailyAndTotalWage = new ArrayList<Integer> ();
	public void calEmpWages(CompanyEmpWage company)
	{
		//variables
		int empHrs = 0, totalEmpHrs = 0, 
		totalWorkingDays = 0,empDailyWage=0,empTotalWage=0;

		while( totalEmpHrs <= company.getMaxHrsInMonth() && totalWorkingDays < company.getMaxWorkingDays() )
		 {
			totalWorkingDays++;
			int empCheck = (int) ( Math.random() * 10 ) % 3;
			switch (empCheck)
			{
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
			empDailyWage=empHrs*company.getEmpRatePerHrs();
			//here store daily wages in arraylist
			empDailyAndTotalWage.add(empDailyWage);
			//print daily many work hours 
			System.out.println("Day: " + totalWorkingDays + " Emp Hr: " +  empHrs+ " empDailyWage: "+empDailyWage);
		}

		// calculate total Wages
		empTotalWage=totalEmpHrs * company.getEmpRatePerHrs();
		//here store the total wages in arraylist
		empDailyAndTotalWage.add(empTotalWage);
		company.setTotalEmpWage(empTotalWage);
		System.out.println("Total Wage of " + company.getCompanyName() + " Employee is " + company.getTotalEmpWage());	
	}

	public static void main(String args[])
	{
		EmpWageComputation empwagecomputation = new EmpWageComputation();
		ArrayList<CompanyEmpWage> companys = new ArrayList<CompanyEmpWage>();

		companys.add( new CompanyEmpWage("BRIDGELABZ",20,20,100));
		empwagecomputation.calEmpWages(companys.get(0));
		
		companys.add( new CompanyEmpWage("CAPGMINI",50, 15, 100));
		empwagecomputation.calEmpWages(companys.get(1));	
	}
}

class CompanyEmpWage
{
	public int EMP_RATE_PER_HRS;
	public int MAX_WORKING_DAYS;
	public int MAX_HRS_IN_MONTH;
	public String COMPANY_NAME;
	
	public int totalEmpWage=0;
	
	public CompanyEmpWage(String COMPANY_NAME,int EMP_RATE_PER_HRS, int MAX_WORKING_DAYS, int MAX_HRS_IN_MONTH)
	{
		this.EMP_RATE_PER_HRS = EMP_RATE_PER_HRS;
		this.MAX_WORKING_DAYS = MAX_WORKING_DAYS;
		this.MAX_HRS_IN_MONTH = MAX_HRS_IN_MONTH;
		this.COMPANY_NAME=COMPANY_NAME;
	}
	//getter methods
	public int getEmpRatePerHrs()
	{
		return EMP_RATE_PER_HRS;
	}

	public int getMaxWorkingDays()
	{
		return MAX_WORKING_DAYS;
	}

	public int getMaxHrsInMonth()
	{
		return MAX_HRS_IN_MONTH;
	}
	public String getCompanyName()	{
		return COMPANY_NAME;
	}
	public void setTotalEmpWage(int totalEmpWage)
	{
		this.totalEmpWage=totalEmpWage;
	}
	public int getTotalEmpWage()
	{
		return totalEmpWage;
	}
}
