package com.troy.young.main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jxls.common.Context;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.jxls.util.JxlsHelper;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {

    private App() {

    }

    public static void main(String[] args) throws IOException, SAXException {
//        Gson gson = new Gson();
//        String json = gson.toJson(prepareSSPWeeklyOrderDTO());
//        System.out.println(json);
//        System.out.println("============================");
//        System.out.println("Generate template");
//
//        // handle the dest file
//        File destFile = new File("/Users/yongzhi.yang/Documents/ssp_weekly_order.xls");
//        if (!destFile.exists()) {
//            destFile.createNewFile();
//        } else {
//            destFile.delete();
//            destFile.createNewFile();
//        }
//        
//        // prepare data
//        SSPWeeklyOrderDTO dto = prepareSSPWeeklyOrderDTO();
//        
//        // export as a file
//        try (InputStream is = App.class.getResourceAsStream("/ssp_order_weekly_template.xls")) {
//            try (OutputStream os = new FileOutputStream(destFile)) {
//                Context context = new Context();
//                context.putVar("dto", dto);
//                JxlsHelper.getInstance().processTemplate(is, os, context);
//                System.out.println("Generate Success.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        // parsing from xls
        try (InputStream inputXML = new BufferedInputStream(App.class.getResourceAsStream("ssp_order_weekly.xml"))) {
            XLSReader reader = ReaderBuilder.buildFromXML(inputXML);
            try (InputStream inputData = new BufferedInputStream(App.class.getResourceAsStream("ssp_weekly_order_cpm_report.xls"))){
                
                List<XLSSspOrderRankerDTO> dto = new ArrayList<>();
                
                XLSSspOrderDTO weeklyOrder = new XLSSspOrderDTO();
                weeklyOrder.setRankers(dto);
                
                Map<String, XLSSspOrderDTO> map = new HashMap<>();
                map.put("order", weeklyOrder);
                
                ReaderConfig.getInstance().setUseDefaultValuesForPrimitiveTypes(true);
                
                XLSReadStatus status = reader.read(inputData, map);
                System.out.println("Parsing Result: " + status.isStatusOK());
                Gson gson = new Gson();
                System.out.println(gson.toJson(weeklyOrder));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static SSPWeeklyOrderDTO prepareSSPWeeklyOrderDTO() {
        SSPWeeklyOrderDTO dto = new SSPWeeklyOrderDTO();

        // build the campaign
        Campaign campaign = new Campaign();
        campaign.setName("JXLS TEST");
        dto.setCampaign(campaign);

        // build the ssp
        SSPOrder order = new SSPOrder();
        order.setId(UUID.randomUUID().toString());
        dto.setSsp(order);

        // build dayparts
        Map<String, Integer> dayparts = new HashMap<String, Integer>();
        dayparts.put("morning", 20);
        dayparts.put("noon", 50);
        dayparts.put("night", 30);
        dto.setDayparts(dayparts);

        // build the weekly dates
        List<String> weeks = new ArrayList<String>();
        weeks.add("6/1");
        weeks.add("6/8");
        weeks.add("6/15");
        dto.setWeeklyDates(weeks);

        // build rankers
        List<Rankers> rankers = new ArrayList<Rankers>();
        rankers.add(new Rankers("ABC", 10, Arrays.asList(20, 30, null)));
        rankers.add(new Rankers("ABC", 20, Arrays.asList(10, 50, 23)));
        rankers.add(new Rankers("CNN", 15, Arrays.asList(23, 12, 85)));
        dto.setRankers(rankers);

        // build network summarys
        List<NetworkSummary> summaries = new ArrayList<NetworkSummary>();
        summaries.add(new NetworkSummary("ABC", 900));
        summaries.add(new NetworkSummary("CNN", 500));
        dto.setNetworks(summaries);

        return dto;
    }
}
