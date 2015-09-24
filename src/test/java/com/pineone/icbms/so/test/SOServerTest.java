package com.pineone.icbms.so.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pineone.icbms.so.Application;
import com.pineone.icbms.so.adp.model.Information;
import com.pineone.icbms.so.adp.model.Occurrence;
import com.pineone.icbms.so.core.model.Device;
import com.pineone.icbms.so.core.model.VirtualObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by existmaster on 2015. 9. 22..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
//For server port Integration
@IntegrationTest("server.port:0")
public class SOServerTest {

    @Autowired private WebApplicationContext wac;
    @Autowired private ObjectMapper objectMapper;

    private MockMvc mock;

    @Value("${local.server.port}")
    int port;

    private Occurrence test;

    @Before
    public void setUp() throws Exception {
        this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
        test = new Occurrence();
        test.setId("OCC_ID_TEST");
    }

    public ResultActions getResultActions(Object object) throws Exception {
        return mock.perform(MockMvcRequestBuilders.post("/occ")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(object)));
    }

    @Test
    public void testMock() throws Exception{
        ResultActions resultActions = getResultActions(test);
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void interfaceSDA() throws Exception{
        Occurrence testB = new Occurrence();
        testB.setId("OCC_001");
        testB.setCmd("occ");
        testB.setContextId("CONTEXT_MODEL_001");
        testB.setTime("20151030153028");
        testB.addDomain(new VirtualObject("VO_CLASS_ROOM_001"));
        testB.addDomain(new VirtualObject("VO_CLASS_ROOM_002"));
        ResultActions resultActions = getResultActions(testB);

        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());


    }

//    //@Test
//    public void canReceivedData(){
//        Occurrence occ = new Occurrence();
//        occ.setId("OCC_ID_001");
//        List<Information> informationList = new ArrayList<>();
//        Information information = new Information();
//        information.setVirtualObjectId("VO_ID_001");
//        List<Device> devices = new ArrayList<>();
//        Device deviceA = new Device("VO_DEVICE_ID_001");
//        Device deviceB = new Device("VO_DEVICE_ID_002");
//        devices.add(deviceA);
//        devices.add(deviceB);
//
//        information.setDevices(devices);
//
//        informationList.add(information);
//
//        occ.setInformations(informationList);
//
//
//    }

    //@Test
//    public void canSaveLadder() {
//        Game testGame = gameRepository.save(new Game(2));
//
//        Player player1 = playerRepository.save(new Player(testGame, "AAA"));
//
//        Ladder ladder1 = ladderRepository.save(new Ladder(player1, 3));
//        Ladder ladder2 = ladderRepository.save(new Ladder(player1, 4));
//        Ladder ladder3 = ladderRepository.save(new Ladder(player2, 2));
//
//        List<Ladder> testladder = ladderRepository.selectByPlayerId(player1.getPlayerId());
//
//        assertEquals(testladder.size(),2);
//
//    }
//    @Test
//    public void canSaveUser() {
//        User user4 = new User("test", "1111", "중성", "바부", "1234@pineone.com");
//
//        when().
//                get("user/add?userId={userId}&password={password}&sex={sex}&nickname={nickname}&email={email}",
//                        user4.getUserId(), user4.getPassword(), user4.getSex(), user4.getNickname(), user4.getEmail()).
//                then().
//                contentType(ContentType.JSON).
//                statusCode(HttpStatus.SC_OK).
//                body("userId", equalTo(user4.getUserId()));
//    }
//
//    @Test
//    public void canFetchUser1() {
//        String user1Id = user1.getUserId();
//
//        when().
//                get("user/search/{userId}", user1Id).
//                then().
//                contentType(ContentType.JSON).
//                statusCode(HttpStatus.SC_OK).
//                body("userId", equalTo(user1Id));
//    }

}
