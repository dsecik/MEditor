/*
 * Metadata Editor
 * 
 * Metadata Editor - Rich internet application for editing metadata.
 * Copyright (C) 2011  Matous Jobanek (matous.jobanek@mzk.cz)
 * Moravian Library in Brno
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * 
 */

package cz.mzk.editor.client.view.window;

import com.google.gwt.event.shared.EventBus;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;

import cz.mzk.editor.client.LangConstants;
import cz.mzk.editor.client.mods.ModsTypeClient;
import cz.mzk.editor.client.view.other.EditorTabSet;
import cz.mzk.editor.client.view.other.HtmlCode;
import cz.mzk.editor.client.view.other.ModsTab;
import cz.mzk.editor.shared.rpc.DublinCore;

/**
 * @author Matous Jobanek
 * @version Apr 26, 2012
 */
public abstract class CreateWindow
        extends UniversalWindow {

    /**
     * @param height
     * @param width
     * @param title
     * @param eventBus
     * @param milisToWait
     */
    public CreateWindow(LangConstants lang, final EditorTabSet topTabSet, EventBus eventBus) {
        super(200, 350, lang.publishName(), eventBus, 20);

        HTMLFlow label = new HTMLFlow(HtmlCode.title(lang.areYouSure(), 3));
        label.setMargin(5);
        label.setExtraSpace(10);
        final DynamicForm form = new DynamicForm();
        form.setMargin(0);
        form.setWidth(100);
        form.setHeight(30);
        form.setExtraSpace(7);

        HTMLFlow setRightsFlow = new HTMLFlow(lang.setRights());

        final CheckboxItem makePublic = new CheckboxItem("makePublic", "public");
        final CheckboxItem makePrivate = new CheckboxItem("makePrivate", "private");
        makePrivate.setValue(true);
        makePublic.addChangedHandler(new ChangedHandler() {

            @Override
            public void onChanged(ChangedEvent event) {
                makePrivate.setValue(!makePublic.getValueAsBoolean());
            }
        });
        makePrivate.addChangedHandler(new ChangedHandler() {

            @Override
            public void onChanged(ChangedEvent event) {
                makePublic.setValue(!makePrivate.getValueAsBoolean());
            }
        });
        Button publish = new Button();
        publish.setTitle(lang.ok());
        publish.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event2) {

                DublinCore dc = null;
                ModsTypeClient mods = null;
                if (topTabSet != null) {
                    dc = topTabSet.getDcTab().getDc();
                    if (topTabSet.getModsTab() != null) {
                        mods = ((ModsTab) topTabSet.getModsTab()).getMods();
                    }
                }
                createAction(dc, mods, makePublic.getValueAsBoolean());
                hide();
            }
        });
        Button cancel = new Button();
        cancel.setTitle(lang.cancel());
        cancel.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event2) {
                hide();
            }
        });
        HLayout hLayout = new HLayout();
        hLayout.setMembersMargin(10);
        hLayout.addMember(publish);
        hLayout.addMember(cancel);
        hLayout.setMargin(5);
        form.setFields(makePublic, makePrivate);
        setEdgeOffset(20);
        addItem(label);
        addItem(setRightsFlow);
        addItem(form);
        addItem(hLayout);

        centerInPage();
        show();
        publish.focus();
    }

    protected abstract void createAction(DublinCore dc, ModsTypeClient mods, Boolean makePublic);
}