/*
 * Copyright (c) 2012-2013, Poplar Yfyang 杨友峰 (poplar1123@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package plum.freemarker.shiro.auth;

import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;

/**
 * <p>
 * .
 * </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-10-27 10:32 AM
 * @since JDK 1.5
 */
public class AuthenticatedTag extends SecureTag {

	@Override
	public void render(Environment env, Map params, TemplateDirectiveBody body)
			throws IOException, TemplateException {

		if (getSubject() != null && getSubject().isAuthenticated()) {
			if (_logger.isDebugEnabled()) {
				_logger.debug("Subject exists and is authenticated.  Tag body will be evaluated.");
			}

			renderBody(env, body);
		} else {
			if (_logger.isDebugEnabled()) {
				_logger.debug("Subject does not exist or is not authenticated.  Tag body will not be evaluated.");
			}
		}
	}
}
