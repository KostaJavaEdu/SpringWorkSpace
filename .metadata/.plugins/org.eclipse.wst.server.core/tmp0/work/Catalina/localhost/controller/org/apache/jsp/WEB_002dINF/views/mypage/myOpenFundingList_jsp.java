/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.47
 * Generated at: 2020-01-08 12:27:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.mypage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myOpenFundingList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1576160540876L));
    _jspx_dependants.put("jar:file:/C:/Edu/SpringWorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/sulJeong/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tlet isEnd = false;\r\n");
      out.write("\t\tlet listCount = $(\".thumb\").length;\r\n");
      out.write("\t\tvar curUrl = location.href;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//정렬 조건 변경 시\r\n");
      out.write("\t\t$(\"[name=order]\").on(\"change\", function() {\r\n");
      out.write("\t\t\t$(\"#mailchimp-subscription-form\").submit();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//스크롤 시\r\n");
      out.write("\t\t$(window).scroll(function() {\r\n");
      out.write("\t\t\tlet $window = $(this);\r\n");
      out.write("            let scrollTop = $window.scrollTop();\r\n");
      out.write("            let windowHeight = $window.height();\r\n");
      out.write("            let documentHeight = $(document).height();\r\n");
      out.write("            \r\n");
      out.write("            if(scrollTop + windowHeight + 30 > documentHeight){\r\n");
      out.write("            \tconsole.log(listCount);\r\n");
      out.write("            \tconsole.log(curUrl);\r\n");
      out.write("            \tvar curParams = curUrl.split('category/')[1];\r\n");
      out.write("        \t\t\r\n");
      out.write("            }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//fetchList();\r\n");
      out.write("\t});\r\n");
      out.write("\t//jquery End\r\n");
      out.write("\t\r\n");
      out.write("\t//리스트 덧붙이기\r\n");
      out.write("\tlet fetchList = function() {\r\n");
      out.write("\t\tif(isEnd == true)\r\n");
      out.write("\t\t\treturn ;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//현재 요소 개수\r\n");
      out.write("\t\tvar listCount = $(\".thumb\").length;\r\n");
      out.write("\r\n");
      out.write("\t\t//현재 url\r\n");
      out.write("\t\tvar curUrl = location.href;\r\n");
      out.write("\t\tvar curParams = curUrl.split('category')[1];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//현재 페이지의 검색 조건\r\n");
      out.write("\t\tvar categoryCode = '0';\r\n");
      out.write("\t\tvar order = null;\r\n");
      out.write("\t\tvar where = null;\r\n");
      out.write("\t\tvar val = null;\r\n");
      out.write("\t\tif(curParams == '')\r\n");
      out.write("\t\t\tcategoryCode = '0';\r\n");
      out.write("\t\telse if(curParams.startWith('3'))\r\n");
      out.write("\t\t\tcategoryCode = curParams.substring(0, 3);\r\n");
      out.write("\t//fetchList End\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Start main-content -->\r\n");
      out.write("<div class=\"main-content\">\r\n");
      out.write("\t<!-- Section: inner-header -->\r\n");
      out.write("\t<section class=\"inner-header divider layer-overlay overlay-dark-8\"\r\n");
      out.write("\t\tdata-bg-img=\"http://placehold.it/1920x1280\">\r\n");
      out.write("\t\t<div class=\"container pt-90 pb-40\">\r\n");
      out.write("\t\t\t<!-- Section Content -->\r\n");
      out.write("\t\t\t<div class=\"section-content\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t<h2 class=\"text-white font-36\">내가 만든 펀딩</h2>\r\n");
      out.write("\t\t\t\t\t\t<!-- <ol class=\"breadcrumb text-left mt-10 white\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Pages</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"active\">Causes Grid</li>\r\n");
      out.write("\t\t\t\t\t\t</ol> -->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section><br><br>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Section: Causes -->\r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<div class=\"container pt-0 pb-40\">\r\n");
      out.write("\t\t\t<div class=\"section-content\">\r\n");
      out.write("\t\t\t\t<div class=\"row multi-row-clearfix\">\r\n");
      out.write("\t\t\t\t\t ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- end main-content -->");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/mypage/myOpenFundingList.jsp(88,6) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/mypage/myOpenFundingList.jsp(88,6) '${myOpenFundingList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${myOpenFundingList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/mypage/myOpenFundingList.jsp(88,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("fundingList");
      // /WEB-INF/views/mypage/myOpenFundingList.jsp(88,6) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVarStatus("status");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write(" \r\n");
            out.write("\t\t\t\t\t\t<div class=\"col-sm-6 col-md-3\">\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"causes bg-silver-light maxwidth500 mb-30\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"thumb\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<a href=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("/mypage/myOpenFunding/");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fundingList.code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"><img\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\tsrc=\"http://placehold.it/320x240\" alt=\"\" class=\"img-fullwidth\"></a>\r\n");
            out.write("\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t<div\r\n");
            out.write("\t\t\t\t\t\t\t\t\tclass=\"causes-details border-1px bg-white clearfix p-15 pb-30\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<h4 class=\"font-16 text-uppercase\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("/mypage/myOpenFunding/");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fundingList.code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fundingList.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t</h4>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<ul class=\"list-inline font-weight-600 font-14 clearfix mb-5\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"pull-left font-weight-400 text-black-333 pr-0\">달성금액:\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"text-theme-colored font-weight-700\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fundingList.stackPrice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</li>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"pull-right font-weight-400 text-black-333 pr-0\">목표금액:\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"text-theme-colored font-weight-700\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fundingList.goalPrice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</li>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"progress-item mt-5\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"progress mb-0\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<div data-percent=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fundingList.stackPrice/fundingList.goalPrice *100}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"progress-bar appeared\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: ");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fundingList.stackPrice/fundingList.goalPrice *100}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("%;\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"percent\">0</span><span class=\"percent\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fundingList.stackPrice/fundingList.goalPrice *100}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("%</span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"pull-left font-weight-400 text-black-333 pr-0\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<strong>펀딩종료 </strong>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"bg-light text-center\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\tdata-countdown=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fundingList.endDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"></div>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<script type=\"text/javascript\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t$(document).ready(function() {\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t$('[data-countdown]').each(function() {\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tvar $this = $(this), finalDate = $(this).data('countdown');\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t$this.countdown(finalDate,function(event) {\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$this.html(event.strftime('%D 일 %H:%M:%S'));\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t});\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t});\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
            out.write("\t\t\t\t\t\t\t\t\t</script>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t \t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}