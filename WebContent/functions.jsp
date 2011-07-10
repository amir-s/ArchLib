<%! 
	public Object show(String name, HttpServletRequest req) {
		if (req.getAttribute(name) == null) {
			return null;
		}else {
			return req.getAttribute(name);
		}
	}
%>