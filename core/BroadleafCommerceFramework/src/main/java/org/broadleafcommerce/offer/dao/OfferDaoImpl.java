/*
 * Copyright 2008-2009 the original author or authors.
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
package org.broadleafcommerce.offer.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.broadleafcommerce.offer.domain.CandidateFulfillmentGroupOffer;
import org.broadleafcommerce.offer.domain.CandidateItemOffer;
import org.broadleafcommerce.offer.domain.CandidateOrderOffer;
import org.broadleafcommerce.offer.domain.FulfillmentGroupAdjustment;
import org.broadleafcommerce.offer.domain.Offer;
import org.broadleafcommerce.offer.domain.OfferInfo;
import org.broadleafcommerce.offer.domain.OrderAdjustment;
import org.broadleafcommerce.offer.domain.OrderItemAdjustment;
import org.broadleafcommerce.profile.util.EntityConfiguration;
import org.broadleafcommerce.time.SystemTime;
import org.springframework.stereotype.Repository;

@Repository("blOfferDao")
public class OfferDaoImpl implements OfferDao {

    @PersistenceContext(unitName="blPU")
    protected EntityManager em;

    @Resource(name="blEntityConfiguration")
    protected EntityConfiguration entityConfiguration;

    public Offer create() {
        return ((Offer) entityConfiguration.createEntityInstance(Offer.class.getName()));
    }

    public OfferInfo createOfferInfo() {
        return ((OfferInfo) entityConfiguration.createEntityInstance(OfferInfo.class.getName()));
    }

    public CandidateOrderOffer createCandidateOrderOffer() {
        return ((CandidateOrderOffer) entityConfiguration.createEntityInstance(CandidateOrderOffer.class.getName()));
    }

    public CandidateItemOffer createCandidateItemOffer() {
        return ((CandidateItemOffer) entityConfiguration.createEntityInstance(CandidateItemOffer.class.getName()));
    }

    public CandidateFulfillmentGroupOffer createCandidateFulfillmentGroupOffer() {
        return ((CandidateFulfillmentGroupOffer) entityConfiguration.createEntityInstance(CandidateFulfillmentGroupOffer.class.getName()));
    }

    public OrderItemAdjustment createOrderItemAdjustment() {
        return ((OrderItemAdjustment) entityConfiguration.createEntityInstance(OrderItemAdjustment.class.getName()));
    }

    public OrderAdjustment createOrderAdjustment() {
        return ((OrderAdjustment) entityConfiguration.createEntityInstance(OrderAdjustment.class.getName()));
    }

    public FulfillmentGroupAdjustment createFulfillmentGroupAdjustment() {
        return ((FulfillmentGroupAdjustment) entityConfiguration.createEntityInstance(FulfillmentGroupAdjustment.class.getName()));
    }

    public void delete(Offer offer) {
        if (!em.contains(offer)) {
            offer = readOfferById(offer.getId());
        }
        em.remove(offer);
    }

    @SuppressWarnings("unchecked")
    public void delete(OfferInfo offerInfo) {
        if (!em.contains(offerInfo)) {
            offerInfo = (OfferInfo) em.find(entityConfiguration.lookupEntityClass(OfferInfo.class.getName()), offerInfo.getId());
        }
        em.remove(offerInfo);
    }

    public Offer save(Offer offer) {
        return em.merge(offer);
    }

    public OfferInfo save(OfferInfo offerInfo) {
        return em.merge(offerInfo);
    }

    @SuppressWarnings("unchecked")
    public List<Offer> readAllOffers() {
        Query query = em.createNamedQuery("BC_READ_ALL_OFFERS");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public Offer readOfferById(Long offerId) {
        return (Offer) em.find(entityConfiguration.lookupEntityClass(Offer.class.getName()), offerId);
    }

    @SuppressWarnings("unchecked")
    public List<Offer> readOffersByAutomaticDeliveryType() {
        Query query = em.createNamedQuery("BC_READ_OFFERS_BY_AUTOMATIC_DELIVERY_TYPE");
        query.setParameter("specifiedDate", SystemTime.asDate());
        List<Offer> result = query.getResultList();
        return result;
    }

}
