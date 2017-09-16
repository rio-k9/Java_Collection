
public class FileTest2 {
	
	public static void PrintCompStats(ObservableList<StockReader.Company> companyLog){
        String basePath = new File("Company Log").getAbsolutePath();
        File compLog = new File(basePath + "/" + "Company Log.txt");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(compLog));
            for (int i=0; i<companyLog.size(); i++){
                String[] companySymbol = companyLog.get(i).getCompanySymbol().split("\\.");
                writer.write(GenerateCompanyLog.stockReportLog(companySymbol[0] ,companyLog.get(i).getCompanyName(), i));
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

}
