package example.annotationproxy3.filter;

import java.util.Collections;
import java.util.List;

/**
 * @author wangxh
 * @date 2022/11/7 2:08 PM
 */
public final class BizFilterChain {
    private BizHandle handle;
    private List<BizFilter> filters;
    private int pos = 0;
    private int size = 0;
    public BizFilterChain(BizHandle handle, List<BizFilter> filterList){
        this.handle = handle;
        this.filters = filterList;
        if(this.filters == null){
            this.filters = Collections.emptyList();
        }
         size = filters.size();
    }
    public void doFilter(BizRequest request) {
        internalDoFilter(request);
    }

    private void internalDoFilter(BizRequest request){
        if(this.pos < size){
            BizFilter filter = this.filters.get(pos++);
            filter.doFilter(request,this);
        }else{
            this.handle.process(request);
        }
    }
}

