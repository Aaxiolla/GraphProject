package GraphProjectInterface;

public interface GraphTool {
    public void clickEvent();
    public void mouseMovedEvent();
    public static final GraphTool ADDNODE = new GraphTool() {
        @Override
        public void clickEvent() {

        }

        @Override
        public void mouseMovedEvent() {

        }
    };
    public static final GraphTool ADDEDGE = new GraphTool() {
        @Override
        public void clickEvent() {

        }

        @Override
        public void mouseMovedEvent() {

        }
    };
    public static final GraphTool REMOVENODE = new GraphTool() {
        @Override
        public void clickEvent() {

        }

        @Override
        public void mouseMovedEvent() {

        }
    };
    public static final GraphTool REMOVEEDGE = new GraphTool() {
        @Override
        public void clickEvent() {

        }

        @Override
        public void mouseMovedEvent() {

        }
    };
}
