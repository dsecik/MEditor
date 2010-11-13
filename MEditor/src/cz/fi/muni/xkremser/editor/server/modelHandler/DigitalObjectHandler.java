/**
 * Metadata Editor
 * @author Jiri Kremser
 *  
 */
package cz.fi.muni.xkremser.editor.server.modelHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.fedora.api.RelationshipTuple;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

import cz.fi.muni.xkremser.editor.client.Constants;
import cz.fi.muni.xkremser.editor.client.KrameriusModel;
import cz.fi.muni.xkremser.editor.server.config.KrameriusModelMapping;
import cz.fi.muni.xkremser.editor.server.fedora.FedoraAccess;
import cz.fi.muni.xkremser.editor.server.fedora.utils.FedoraUtils;
import cz.fi.muni.xkremser.editor.shared.valueobj.AbstractDigitalObjectDetail;

// TODO: Auto-generated Javadoc
/**
 * The Class DigitalObjectHandler.
 */
public class DigitalObjectHandler implements CanGetObject {

	/** The fedora access. */
	private final FedoraAccess fedoraAccess;

	/** The logger. */
	private final Log logger;

	/** The injector. */
	@Inject
	private Injector injector;

	/**
	 * Instantiates a new digital object handler.
	 * 
	 * @param logger
	 *          the logger
	 * @param fedoraAccess
	 *          the fedora access
	 */
	@Inject
	public DigitalObjectHandler(final Log logger, @Named("securedFedoraAccess") FedoraAccess fedoraAccess) {
		this.logger = logger;
		this.fedoraAccess = fedoraAccess;
	}

	ArrayList<ArrayList<String>> getRelated(final String uuid) {
		List<RelationshipTuple> triplets = FedoraUtils.getSubjectPids(Constants.FEDORA_UUID_PREFIX + uuid);
		ArrayList<ArrayList<String>> returnList = new ArrayList<ArrayList<String>>(triplets.size());
		for (RelationshipTuple triplet : triplets) {
			ArrayList<String> relatedRecord = new ArrayList<String>(2);
			String subject = triplet.getSubject().substring((Constants.FEDORA_INFO_PREFIX + Constants.FEDORA_UUID_PREFIX).length());
			String predicate = triplet.getPredicate().substring(Constants.FEDORA_INFO_PREFIX.length());
			relatedRecord.add(subject);
			relatedRecord.add(predicate);
			returnList.add(relatedRecord);
		}
		return returnList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cz.fi.muni.xkremser.editor.server.modelHandler.CanGetObject#getDigitalObject
	 * (java.lang.String)
	 */
	@Override
	public AbstractDigitalObjectDetail getDigitalObject(String uuid, final boolean findRelated) {
		KrameriusModel model = null;
		try {
			model = fedoraAccess.getKrameriusModel(uuid);
		} catch (IOException e) {
			logger.warn("Could not get model of object " + uuid + ". Using generic model handler.", e);
		}
		CanGetObject handler = null;
		if (model != null) {
			handler = injector.getInstance(KrameriusModelMapping.TYPES.get(model));
		} else {
			handler = injector.getInstance(GenericHandler.class);
		}

		return handler.getDigitalObject(uuid, findRelated);
	}

	/**
	 * Gets the fedora access.
	 * 
	 * @return the fedora access
	 */
	public FedoraAccess getFedoraAccess() {
		return fedoraAccess;
	}

}