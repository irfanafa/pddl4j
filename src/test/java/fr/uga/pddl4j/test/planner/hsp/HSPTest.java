package fr.uga.pddl4j.test.planner.hsp;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.encoding.JsonAdapter;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;
import fr.uga.pddl4j.planners.hsp.HSP;
import fr.uga.pddl4j.test.Tools;
import fr.uga.pddl4j.util.Plan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Implements the <tt>HSPTest</tt> of the PDD4L library. The planner accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 * <p>
 * This class will test the planner on benchmark domain and problem from International planning contest.
 * The goal here is to test the PDDL4J 3.0 plan using all the file used in the competition and
 * KCL-Planning validator: https://github.com/KCL-Planning/VAL
 * </p>
 * <p>
 * Note that IPC benchmark files are note delivered with the source code because of their 3GB size.
 * It suppose benchmark directory is a the root of your project.
 * If no test files are provided all test will pass the validation.
 * </p>
 *
 * @author Cédric Gerard
 * @version 0.1 - 23.06.16
 */
public class HSPTest {

    /**
     * Computation timeout.
     */
    private static final int TIMEOUT = 10;

    /**
     * Default Trace level.
     */
    private static final int TRACE_LEVEL = 0;

    /**
     * Default statistics computation.
     */
    private static final boolean STATISTICS = false;

    /**
     * The HSP planner reference.
     */
    private HSP planner = null;


    /**
     * Test initialization.
     */
    @Before
    public void initTest() {
        // Creates the planner
        planner = new HSP();
        planner.setTimeOut(TIMEOUT);
        planner.setTraceLevel(TRACE_LEVEL);
        planner.setSaveState(STATISTICS);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 gripper tests
     */
    @Test
    public void testHSP_IPC1_gripper()  {
        String localTestPath = Tools.BENCH_DIR + "ipc1"
            + File.separator + "gripper"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 logistics tests
     */
    @Test
    public void testHSP_IPC1_logistics()  {
        String localTestPath = Tools.BENCH_DIR + "ipc1"
            + File.separator + "logistics"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 movie tests
     */
    @Test
    public void testHSP_IPC1_movie()  {
        String localTestPath = Tools.BENCH_DIR + "ipc1"
            + File.separator + "movie"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 mprime tests
     */
    @Test
    public void testHSP_ICP1_mprime()  {
        String localTestPath = Tools.BENCH_DIR + "ipc1"
            + File.separator + "mprime"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC1 mystery tests
     */
    @Test
    public void testHSP_IPC1_mystery()  {
        String localTestPath = Tools.BENCH_DIR + "ipc1"
            + File.separator + "mystery"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 blocksworld tests
     */
    @Test
    public void testHSP_IPC2_blocksworld()  {
        String localTestPath = Tools.BENCH_DIR + "ipc2"
            + File.separator + "blocksworld"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 elevator tests
     */
    @Test
    public void testHSP_IPC2_elevator()  {
        String localTestPath = Tools.BENCH_DIR + "ipc2"
            + File.separator + "elevator"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 freecell tests
     */
    @Test
    public void testHSP_IPC2_freecell()  {
        String localTestPath = Tools.BENCH_DIR + "ipc2"
            + File.separator + "freecell"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC2 schedule tests
     */
    //@Test
    public void testHSP_IPC2_schedule()  {
        String localTestPath = Tools.BENCH_DIR + "ipc2"
            + File.separator + "schedule"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC3 depots tests
     */
    @Test
    public void testHSP_IPC3_depots()  {
        String localTestPath = Tools.BENCH_DIR + "ipc3"
            + File.separator + "depot"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC3 driverlog tests
     */
    @Test
    public void testHSP_IPC3_driverlog()  {
        String localTestPath = Tools.BENCH_DIR + "ipc3"
            + File.separator + "driverlog"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC3 rover tests
     */
    @Test
    public void testHSP_IPC3_rover()  {
        String localTestPath = Tools.BENCH_DIR + "ipc3"
            + File.separator + "rover"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }


    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC3 satellite tests
     */
    @Test
    public void testHSP_IPC3_satellite()  {
        String localTestPath = Tools.BENCH_DIR + "ipc3"
            + File.separator + "satellite"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC3 zenotravel tests
     */
    @Test
    public void testHSP_IPC3_zenotravel()  {
        String localTestPath = Tools.BENCH_DIR + "ipc3"
            + File.separator + "zenotravel"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC4 airport tests
     */
    @Test
    public void testHSP_IPC4_airport()  {
        String localTestPath = Tools.BENCH_DIR + "ipc4"
            + File.separator + "airport"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC4 optical-telegraph tests
     */
    @Test
    public void testHSP_IPC4_optical_telegraph()  {
        String localTestPath = Tools.BENCH_DIR + "ipc4"
            + File.separator + "optical-telegraph"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC4 philosophers tests
     */
    @Test
    public void testHSP_IPC4_philosophers()  {
        String localTestPath = Tools.BENCH_DIR + "ipc4"
            + File.separator + "philosophers"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC4 pipeworld tests
     */
    @Test
    public void testHSP_IPC4_pipeworld()  {
        String localTestPath = Tools.BENCH_DIR + "ipc5"
            + File.separator + "pipeworld"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC4 psr tests
     */
    @Test
    public void testHSP_IPC4_psr()  {
        String localTestPath = Tools.BENCH_DIR + "ipc4"
            + File.separator + "psr"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC5 openstacks tests
     */
    @Test
    public void testHSP_IPC5_openstacks()  {
        String localTestPath = Tools.BENCH_DIR + "ipc5"
            + File.separator + "openstacks"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC5 pathways tests
     */
    @Test
    public void testHSP_IPC5_pathways()  {
        String localTestPath = Tools.BENCH_DIR + "ipc5"
            + File.separator + "pathways"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC5 storage tests
     */
    @Test
    public void testHSP_IPC5_storage()  {
        String localTestPath = Tools.BENCH_DIR + "ipc5"
            + File.separator + "storage"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC5 tpp tests
     */
    @Test
    public void testHSP_IPC5_tpp()  {
        String localTestPath = Tools.BENCH_DIR + "ipc5"
            + File.separator + "tpp"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC5 truck tests
     */
    @Test
    public void testHSP_IPC5_truck()  {
        String localTestPath = Tools.BENCH_DIR + "ipc5"
            + File.separator + "truck"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC6 pegsol tests
     */
    @Test
    public void testHSP_IPC6_pegsol()  {
        String localTestPath = Tools.BENCH_DIR + "ipc6"
            + File.separator + "pegsol"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC6 sokoban tests
     */
    @Test
    public void testHSP_IPC6_sokoban()  {
        String localTestPath = Tools.BENCH_DIR + "ipc6"
            + File.separator + "sokoban"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC6 transport tests
     */
    @Test
    public void testHSP_IPC6_transport()  {
        String localTestPath = Tools.BENCH_DIR + "ipc6"
            + File.separator + "transport"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC7 barman tests
     */
    @Test
    public void testHSP_IPC7_barman()  {
        String localTestPath = Tools.BENCH_DIR + "ipc7"
            + File.separator + "barman"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC7 nomystery tests
     */
    @Test
    public void testHSP_IPC7_nomystery()  {
        String localTestPath = Tools.BENCH_DIR + "ipc7"
            + File.separator + "nomystery"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC7 parking tests
     */
    @Test
    public void testHSP_IPC7_parking()  {
        String localTestPath = Tools.BENCH_DIR + "ipc7"
            + File.separator + "parking"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC8 childsnack tests
     */
    @Test
    public void testHSP_IPC8_childsnack()  {
        String localTestPath = Tools.BENCH_DIR + "ipc8"
            + File.separator + "childsnack"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC8 hiking tests
     */
    @Test
    public void testHSP_IPC8_hiking()  {
        String localTestPath = Tools.BENCH_DIR + "ipc8"
            + File.separator + "hiking"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * IPC8 thoughtful tests
     */
    @Test
    public void testHSP_IPC8_thoughtful()  {
        String localTestPath = Tools.BENCH_DIR + "ipc8"
            + File.separator + "thoughtful"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * Other Depots tests
     */
    @Test
    public void testHSP_newTests_Depots()  {
        String localTestPath = Tools.BENCH_DIR + "newTests"
            + File.separator + "Depots"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * Other DriverLog tests
     */
    @Test
    public void testHSP_newTests_DriverLog()  {
        String localTestPath = Tools.BENCH_DIR + "newTests"
            + File.separator + "DriverLog"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * Other Freecell tests
     */
    @Test
    public void testHSP_newTests_Freecell()  {
        String localTestPath = Tools.BENCH_DIR + "newTests"
            + File.separator + "Freecell"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * Other Rover tests
     */
    @Test
    public void testHSP_newTests_Rover()  {
        String localTestPath = Tools.BENCH_DIR + "newTests"
            + File.separator + "Rover"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * Other Satellite tests
     */
    @Test
    public void testHSP_newTests_Satellite()  {
        String localTestPath = Tools.BENCH_DIR + "newTests"
            + File.separator + "Satellite"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * Method that executes benchmarks using files on the hsp planner to test its output plan.
     * Other Zenotravel tests
     */
    @Test
    public void testHSP_newTests_Zenotravel()  {
        String localTestPath = Tools.BENCH_DIR + "newTests"
            + File.separator + "Zenotravel"
            + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark [directory: " + localTestPath + "] test skipped !");
            return;
        }

        generateValOutputPlans(localTestPath);
    }

    /**
     * test the HSP JSON output method on Gripper p01 problem.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testHSP_json_output_plan() throws Exception {

        final ProblemFactory factory = new ProblemFactory();
        String domainFile = "pddl/gripper/domain.pddl";
        String problemFile = "pddl/gripper/p01.pddl";
        String jsonPlan = "";

        ErrorManager errorManager = factory.parse(new File(domainFile), new File(problemFile));
        Assert.assertTrue(errorManager.isEmpty());

        CodedProblem pb = factory.encode();
        if (pb.isSolvable()) {
            Plan plan = planner.search(pb);
            JsonAdapter toJson = new JsonAdapter(pb);
            jsonPlan = toJson.toJsonString(plan);
        }

        Assert.assertFalse(jsonPlan == null);
        Assert.assertFalse(jsonPlan.contentEquals(""));
        Assert.assertTrue(jsonPlan.contentEquals(validGripperP01JSON));
    }

    /**
     * Generate output plan KLC-planning validator formatted.
     *
     * @param currentTestPath the current sub dir to test
     */
    private void generateValOutputPlans(String currentTestPath) {
        Tools.cleanValPlan(currentTestPath);
        final ProblemFactory factory = new ProblemFactory();
        String currentDomain = currentTestPath + Tools.DOMAIN;
        boolean oneDomainPerProblem = false;
        String problemFile;
        String currentProblem;

        // Counting the number of problem files
        File[] pbFileList = new File(currentTestPath)
            .listFiles((dir, name) -> name.startsWith("p") && name.endsWith(".pddl") && !name.contains("dom"));

        int nbTest = 0;
        if (pbFileList != null) {
            nbTest = pbFileList.length;
        }

        // Check if there is on domain per problem or a shared domain for all
        if (!new File(currentDomain).exists()) {
            oneDomainPerProblem = true;
        }

        // Loop around problems in one category
        for (int i = 1; i < nbTest + 1; i++) {
            if (i < 10) {
                problemFile = "p0" + i + Tools.PDDL_EXT;
            } else {
                problemFile = "p" + i + Tools.PDDL_EXT;
            }

            currentProblem = currentTestPath + problemFile;

            if (oneDomainPerProblem) {
                currentDomain = currentTestPath + problemFile.split(".p")[0] + "-" + Tools.DOMAIN;
            }
            System.out.println("--");
            // Parses the PDDL domain and problem description
            try {
                factory.setTraceLevel(TRACE_LEVEL);

                ErrorManager errorManager = factory.parse(new File(currentDomain), new File(currentProblem));
                Assert.assertTrue(errorManager.isEmpty());

                CodedProblem pb = null;
                Plan plan = null;
                try {
                    // Encodes and instantiates the problem in a compact representation
                    System.out.println("Encoding [" + currentProblem + "]" + "...");
                    pb = factory.encode();
                    if (pb.isSolvable()) {
                        // Searches for a solution plan
                        System.out.println("Trying to solve [" + currentProblem + "]" + " in " + TIMEOUT + " seconds");
                        plan = planner.search(pb);
                    } else {
                        System.err.println("Problem [" + currentProblem + "]" + " not solvable.");
                    }
                } catch (OutOfMemoryError err) {
                    System.out.println("ERR: " + err.getMessage() + " - test aborted");
                    return;
                } catch (IllegalArgumentException iaex) {
                    if (iaex.getMessage().equalsIgnoreCase("problem to encode not ADL")) {
                        System.err.println("[" + currentProblem + "]: Not ADL problem!");
                    } else {
                        throw iaex;
                    }
                }

                if (plan == null) { // no solution in TIMEOUT computation time
                    System.out.println("No solution found in " + TIMEOUT + " seconds for " + currentProblem);
                } else if (plan.isEmpty()) { // Empty solution
                    System.out.println("Empty solution for " + currentProblem);
                } else { // Save output plan
                    try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(currentProblem.substring(0,
                        currentProblem.length() - Tools.PDDL_EXT.length()) + Tools.PLAN_EXT))) {
                        bw.write(pb.toString(plan));
                    }
                    System.out.println("Solution found for " + currentProblem);
                }

            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
            System.out.println("--");
        }
    }

    /**
     * Valid JSON output for gripper p01 problem.
     */
    private static String validGripperP01JSON =
        "{\"Action 1\":{\"Names\":\"pick\",\"Parameters\":[\"ball2\",\"rooma\",\"right\"],"
            + "\"Position\":1,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\",\"(free right)\","
            + "\"(at ball2 rooma)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},"
            + "\"Effect\":{\"Negatives\":[\"(free right)\",\"(at ball2 rooma)\"],\"Positives\":[\"(carry ball2 right)\""
            + "]}}]},\"Action 0\":{\"Names\":\"pick\",\"Parameters\":[\"ball4\",\"rooma\",\"left\"],\"Position\":0,"
            + "\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\",\"(at ball4 rooma)\",\""
            + "(free left)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\""
            + ":{\"Negatives\":[\"(at ball4 rooma)\",\"(free left)\"],\"Positives\":[\"(carry ball4 left)\"]}}]},"
            + "\"Size\":11,\"Action 5\":{\"Names\":\"move\",\"Parameters\":[\"roomb\",\"rooma\"],\"Position\":5,"
            + "\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby roomb)\"]},\"Condition_Expressions\""
            + ":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(at-robby roomb)\"],"
            + "\"Positives\":[\"(at-robby rooma)\"]}}]},\"Type_de_plan\":1,\"Action 4\":{\"Names\":\"drop\","
            + "\"Parameters\":[\"ball4\",\"roomb\",\"left\"],\"Position\":4,\"Preconditions\":{\"Negatives\":[],"
            + "\"Positives\":[\"(at-robby roomb)\",\"(carry ball4 left)\"]},\"Condition_Expressions\":[{\"Condition\""
            + ":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball4 left)\"],\"Positives\""
            + ":[\"(free left)\",\"(at ball4 roomb)\"]}}]},\"Makespan\":11.0,\"Action 3\":{\"Names\":\"drop\","
            + "\"Parameters\":[\"ball2\",\"roomb\",\"right\"],\"Position\":3,\"Preconditions\":{\"Negatives\":[],"
            + "\"Positives\":[\"(at-robby roomb)\",\"(carry ball2 right)\"]},\"Condition_Expressions\":[{\"Condition\""
            + ":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball2 right)\"],\"Positives\""
            + ":[\"(free right)\",\"(at ball2 roomb)\"]}}]},\"Action 2\":{\"Names\":\"move\",\"Parameters\":[\"rooma\","
            + "\"roomb\"],\"Position\":2,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\"]},"
            + "\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\""
            + ":[\"(at-robby rooma)\"],\"Positives\":[\"(at-robby roomb)\"]}}]},\"Action 10\":{\"Names\":\"drop\","
            + "\"Parameters\":[\"ball3\",\"roomb\",\"left\"],\"Position\":10,\"Preconditions\":{\"Negatives\":[],"
            + "\"Positives\":[\"(at-robby roomb)\",\"(carry ball3 left)\"]},\"Condition_Expressions\":[{\"Condition\""
            + ":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball3 left)\"],\"Positives\""
            + ":[\"(free left)\",\"(at ball3 roomb)\"]}}]},\"Action 9\":{\"Names\":\"drop\",\"Parameters\":[\"ball1\","
            + "\"roomb\",\"right\"],\"Position\":9,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\""
            + "(at-robby roomb)\",\"(carry ball1 right)\"]},\"Condition_Expressions\":[{\"Condition\":{\"Negatives\""
            + ":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(carry ball1 right)\"],\"Positives\":[\"(free right)"
            + "\",\"(at ball1 roomb)\"]}}]},\"Cost\":11.0,\"Action 8\":{\"Names\":\"move\",\"Parameters\":[\"rooma\","
            + "\"roomb\"],\"Position\":8,\"Preconditions\":{\"Negatives\":[],\"Positives\":[\"(at-robby rooma)\"]},"
            + "\"Condition_Expressions\":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\""
            + ":[\"(at-robby rooma)\"],\"Positives\":[\"(at-robby roomb)\"]}}]},\"Action 7\":{\"Names\":\"pick\","
            + "\"Parameters\":[\"ball3\",\"rooma\",\"left\"],\"Position\":7,\"Preconditions\":{\"Negatives\":[],"
            + "\"Positives\":[\"(at-robby rooma)\",\"(free left)\",\"(at ball3 rooma)\"]},\"Condition_Expressions\""
            + ":[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(free left)\","
            + "\"(at ball3 rooma)\"],\"Positives\":[\"(carry ball3 left)\"]}}]},\"Action 6\":{\"Names\":\"pick\","
            + "\"Parameters\":[\"ball1\",\"rooma\",\"right\"],\"Position\":6,\"Preconditions\":{\"Negatives\":[],"
            + "\"Positives\":[\"(at-robby rooma)\",\"(free right)\",\"(at ball1 rooma)\"]},\"Condition_Expressions\":"
            + "[{\"Condition\":{\"Negatives\":[],\"Positives\":[]},\"Effect\":{\"Negatives\":[\"(free right)\","
            + "\"(at ball1 rooma)\"],\"Positives\":[\"(carry ball1 right)\"]}}]},\"timeSpecifiers\""
            + ":[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}";
}
