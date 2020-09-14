package airline;

import org.apache.hadoop.io.Text;

public class AirlinePerformanceParser {
 
    private int     year;
    private int     month;
     
    private int     arriveDelayTime = 0;
    private int     departureDelayTime = 0;
    private int     distance = 0;
     
    private boolean arriveDelayAvailable = true;
    private boolean departureDelayAvailable = true;
    private boolean distanceAvailable = true;
     
    private     String  uniqueCarrier;
 
    public AirlinePerformanceParser(Text text) {
        try{
            String [] colums = text.toString().split(",");
             
            // ���� ����
            year = Integer.parseInt(colums[0]);
             
            // ���� ��
            month = Integer.parseInt(colums[1]);
             
            // �װ��� �ڵ�
            uniqueCarrier = colums[9];
             
            // �װ��� ��� ���� �ð�
            if(!colums[15].equals("NA")){
                departureDelayTime = Integer.parseInt(colums[15]);
            }else {
                departureDelayAvailable = false;
            }
             
            // �װ��� ���� ���� �ð�
            if(!colums[14].equals("NA")){
                arriveDelayTime = Integer.parseInt(colums[14]);
            }else {
                arriveDelayAvailable = false;
            }
 
            // ���� �Ÿ�
            if(!colums[18].equals("NA")){
                distance = Integer.parseInt(colums[18]);
            }else {
                distanceAvailable = false;
            }
             
        }catch(Exception e){
            System.out.println("Error parsing a record : " + e.getMessage());
        }
    }
 
    public int getYear() {
        return year;
    }
 
    public int getMonth() {
        return month;
    }
 
    public int getArriveDelayTime() {
        return arriveDelayTime;
    }
 
    public int getDepartureDelayTime() {
        return departureDelayTime;
    }
 
    public int getDistance() {
        return distance;
    }
 
    public boolean isArriveDelayAvailable() {
        return arriveDelayAvailable;
    }
 
    public boolean isDepartureDelayAvailable() {
        return departureDelayAvailable;
    }
 
    public boolean isDistanceAvailable() {
        return distanceAvailable;
    }
 
    public String getUniqueCarrier() {
        return uniqueCarrier;
    }
}
