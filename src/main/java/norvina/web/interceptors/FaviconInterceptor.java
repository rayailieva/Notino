package norvina.web.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class FaviconInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String link = "https://pbs.twimg.com/profile_images/1016662329650548736/kGTuID4Z_400x400.jpg";

        if (modelAndView != null) {
            modelAndView.addObject("favicon", link);
        }
    }
}
