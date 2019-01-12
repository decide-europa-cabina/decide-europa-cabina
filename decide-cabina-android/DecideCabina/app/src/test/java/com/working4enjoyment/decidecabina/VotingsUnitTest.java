package com.working4enjoyment.decidecabina;

import android.util.Log;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href='http://d.android.com/tools/testing'>Testing documentation</a>
 */
public class VotingsUnitTest {
    @Test
    public void serialize_votings() throws Exception {
        String response= "[{'id':2,'name':'Prueba Si o No','desc':'Descripción de la votación','question':{'desc':'Pregunta','options':[{'number':1,'option':'Sí'},{'number':2,'option':'No'}]},'start_date':'2019-01-09T22:36:00.236792Z','end_date':'2019-01-10T00:01:43.386638Z','pub_key':'null','auths':[],'tally':'null','postproc':'null'},{'id':3,'name':'Votación nueva','desc':'Descripción','question':{'desc':'¿Es buena la API?','options':[{'number':1,'option':'Sí'},{'number':2,'option':'No'}]},'start_date':'null','end_date':'null','pub_key':'null','auths':[{'name':'api-buena','url':'https://decide-europa-cabina.herokuapp.com','me':true}],'tally':'null','postproc':'null'},{'id':1,'name':'Primera votación','desc':'Es una votación para probar la API','question':{'desc':'¿Es buena la API?','options':[{'number':1,'option':'Sí'},{'number':2,'option':'No'}]},'start_date':'2019-01-11T17:25:30.301756Z','end_date':'null','pub_key':{'p':105871163067221650037439561895702777332940781293623638112167294460071768361287,'g':36835214898235557994170632922004723818455227243839323797081743043342736388095,'y':13627979935506270098730444317757911797820911090642222092990159233385375418956},'auths':[{'name':'api-buena','url':'https://decide-europa-cabina.herokuapp.com','me':true}],'tally':'null','postproc':'null'}]";
        assertNotNull(Utility.serializeVoting(response));
    }

    @Test
    public void serialize_votings_one_without_question() throws Exception {
        String response= "[{'id':2,'name':'Prueba Si o No','desc':'Descripción de la votación','start_date':'2019-01-09T22:36:00.236792Z','end_date':'2019-01-10T00:01:43.386638Z','pub_key':'null','auths':[],'tally':'null','postproc':'null'},{'id':3,'name':'Votación nueva','desc':'Descripción','question':{'desc':'¿Es buena la API?','options':[{'number':1,'option':'Sí'},{'number':2,'option':'No'}]},'start_date':'null','end_date':'null','pub_key':'null','auths':[{'name':'api-buena','url':'https://decide-europa-cabina.herokuapp.com','me':true}],'tally':'null','postproc':'null'},{'id':1,'name':'Primera votación','desc':'Es una votación para probar la API','question':{'desc':'¿Es buena la API?','options':[{'number':1,'option':'Sí'},{'number':2,'option':'No'}]},'start_date':'2019-01-11T17:25:30.301756Z','end_date':'null','pub_key':{'p':105871163067221650037439561895702777332940781293623638112167294460071768361287,'g':36835214898235557994170632922004723818455227243839323797081743043342736388095,'y':13627979935506270098730444317757911797820911090642222092990159233385375418956},'auths':[{'name':'api-buena','url':'https://decide-europa-cabina.herokuapp.com','me':true}],'tally':'null','postproc':'null'}]";
        assertNull(Utility.serializeVoting(response));
    }



}