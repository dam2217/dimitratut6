//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//
//public class TestServlet {
//    @Mock
//    HttpServletRequest request;
//    @Mock
//    HttpServletResponse response;
//    @Before
//    public void setUp() throws Exception{
//        MockitoAnnotations.initMocks(this);
//    }
//    @Test
//    public void testDoGet() throws IOException, ServletException {
//        StringWriter stringWriter=new StringWriter();
//        PrintWriter printWriter=new PrintWriter(stringWriter);
//        when(response.getWriter()).thenReturn(printWriter);
//        when(request.getServletPath()).thenReturn("/patients");
//        MyServlet myServlet=new HospDB();
//        myServlet.doGet(request,response);
//        String output=stringWriter.getBuffer().toString();
//        Assert.assertThat(output,is(equalTo("Hello, World!")));
//    }
//}
