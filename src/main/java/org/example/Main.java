package org.example;

import org.example.entityСlasses.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //INIT DATABASE
        try {
            DatabaseInitService.initDatabase();
        } catch (SQLException e) {
            throw new RuntimeException("Some problems with initialization DB");
        }

        //POPULATE DATABASE
        try {
            DatabasePopulateService.populateDatabase();
        } catch (SQLException e) {
            throw new RuntimeException("Some problems with populate DB");
        }

        //FIND LONGEST PROJECT
        try {
            List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProject();
        } catch (SQLException e) {
            throw new RuntimeException("Some problems with find longest project");
        }

        //FIND MAX COUNT CLIENT
        try {
            List<MaxProjectCountClient> maxProjectsClients = new DatabaseQueryService().findMaxProjectsClient();
        } catch (SQLException e) {
            throw new RuntimeException("Some problems with find max projects client");
        }

        //FIND MAX SALARY WORKER
        try {
            List<Worker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorker();
        } catch (SQLException e) {
            throw new RuntimeException("Some problems with find max salary worker");
        }

        //FIND YOUNGEST ELDEST WORKER
        try {
            List<YoungestAndEldestWorker> youngestAndEldestWorkers = new DatabaseQueryService().findYoungestAndEldestWorker();
        } catch (SQLException e) {
            throw new RuntimeException("Some problems with find youngest and eldest workers");
        }

        //PRINT PROJECTS PRICES
        try {
            List<ProjectPrice> projectsPrices = new DatabaseQueryService().getProjectPrices();
            for (ProjectPrice elem: projectsPrices){
                System.out.println(elem);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Some problems with get projects prices");
        }
    }
}
