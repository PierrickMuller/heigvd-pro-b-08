--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

-- Started on 2019-03-22 11:33:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 205 (class 1259 OID 16939)
-- Name: Categorie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Categorie" (
    categorie_id SERIAL NOT NULL,
    nom character varying(20) NOT NULL,
    couleur smallint
);


ALTER TABLE public."Categorie" OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16954)
-- Name: Limite; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Limite" (
    limite_id SERIAL NOT NULL,
    date date NOT NULL,
    valeur integer NOT NULL,
    utilisateur_id integer NOT NULL,
    recurence_id integer NOT NULL,
    sous_categorie_id integer NOT NULL
);


ALTER TABLE public."Limite" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16925)
-- Name: Modele_transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Modele_transaction" (
    modele_transaction_id SERIAL NOT NULL,
    valeur money NOT NULL,
    date date NOT NULL,
    note text,
    utilisateur_id integer NOT NULL,
    sous_categorie_id integer NOT NULL,
    type_transaction_id integer NOT NULL,
    recurence_id integer
);


ALTER TABLE public."Modele_transaction" OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16883)
-- Name: Notification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Notification" (
    notification_id SERIAL NOT NULL,
    titre character varying(30) NOT NULL,
    message character varying,
    utilisateur_id integer NOT NULL
);


ALTER TABLE public."Notification" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16915)
-- Name: Options; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Options" (
    options_id SERIAL NOT NULL,
    rappel_email boolean NOT NULL
);


ALTER TABLE public."Options" OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16907)
-- Name: Pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Pays" (
    pays_id SERIAL NOT NULL,
    nom character varying(30) NOT NULL
);


ALTER TABLE public."Pays" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16920)
-- Name: Recurence; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Recurence" (
    recurence_id SERIAL NOT NULL,
    "Periodicite" character varying(20) NOT NULL
);


ALTER TABLE public."Recurence" OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16944)
-- Name: Sous_categorie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Sous_categorie" (
    sous_categorie_id SERIAL NOT NULL,
    nom character varying(20) NOT NULL,
    categorie_id integer NOT NULL
);


ALTER TABLE public."Sous_categorie" OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16899)
-- Name: Statut; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Statut" (
    statut_id SERIAL NOT NULL,
    nom character varying(30) NOT NULL
);


ALTER TABLE public."Statut" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16933)
-- Name: Transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Transaction" (
    transaction_id SERIAL NOT NULL,
    valeur money NOT NULL,
    date date NOT NULL,
    modele_transaction_id integer NOT NULL
);


ALTER TABLE public."Transaction" OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16949)
-- Name: Type_transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Type_transaction" (
    type_transaction_id SERIAL NOT NULL,
    type character varying(20) NOT NULL
);


ALTER TABLE public."Type_transaction" OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16877)
-- Name: Utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Utilisateur" (
    utilisateur_id SERIAL NOT NULL,
    prenom character varying(30) NOT NULL,
    nom character varying(30) NOT NULL,
    email character varying(50) NOT NULL,
    pseudo character varying(20) NOT NULL,
    mdp character varying(60) NOT NULL,
    genre boolean,
    anniversaire date NOT NULL,
    cree_a timestamp without time zone DEFAULT now(),
    droit_id integer NOT NULL,
    statut_id integer,
    pays_id integer,
    options_id integer NOT NULL
);


ALTER TABLE public."Utilisateur" OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16891)
-- Name: droit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.droit (
    droit_id SERIAL NOT NULL,
    nom character varying(20) NOT NULL
);


ALTER TABLE public.droit OWNER TO postgres;

--
-- TOC entry 2908 (class 0 OID 16939)
-- Dependencies: 205
-- Data for Name: Categorie; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 2911 (class 0 OID 16954)
-- Dependencies: 208
-- Data for Name: Limite; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2906 (class 0 OID 16925)
-- Dependencies: 203
-- Data for Name: Modele_transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 2900 (class 0 OID 16883)
-- Dependencies: 197
-- Data for Name: Notification; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 2904 (class 0 OID 16915)
-- Dependencies: 201
-- Data for Name: Options; Type: TABLE DATA; Schema: public; Owner: postgres
--




--
-- TOC entry 2903 (class 0 OID 16907)
-- Dependencies: 200
-- Data for Name: Pays; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 2905 (class 0 OID 16920)
-- Dependencies: 202
-- Data for Name: Recurence; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 2909 (class 0 OID 16944)
-- Dependencies: 206
-- Data for Name: Sous_categorie; Type: TABLE DATA; Schema: public; Owner: postgres
--




--
-- TOC entry 2902 (class 0 OID 16899)
-- Dependencies: 199
-- Data for Name: Statut; Type: TABLE DATA; Schema: public; Owner: postgres
--




--
-- TOC entry 2907 (class 0 OID 16933)
-- Dependencies: 204
-- Data for Name: Transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--




--
-- TOC entry 2910 (class 0 OID 16949)
-- Dependencies: 207
-- Data for Name: Type_transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2899 (class 0 OID 16877)
-- Dependencies: 196
-- Data for Name: Utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2901 (class 0 OID 16891)
-- Dependencies: 198
-- Data for Name: droit; Type: TABLE DATA; Schema: public; Owner: postgres
--

--
-- TOC entry 2757 (class 2606 OID 16943)
-- Name: Categorie Categorie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Categorie"
    ADD CONSTRAINT "Categorie_pkey" PRIMARY KEY (categorie_id);


--
-- TOC entry 2763 (class 2606 OID 16958)
-- Name: Limite Limite_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Limite"
    ADD CONSTRAINT "Limite_pkey" PRIMARY KEY (limite_id);


--
-- TOC entry 2753 (class 2606 OID 16932)
-- Name: Modele_transaction Modele_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Modele_transaction"
    ADD CONSTRAINT "Modele_transaction_pkey" PRIMARY KEY (modele_transaction_id);


--
-- TOC entry 2741 (class 2606 OID 16887)
-- Name: Notification Notification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Notification"
    ADD CONSTRAINT "Notification_pkey" PRIMARY KEY (notification_id);


--
-- TOC entry 2749 (class 2606 OID 16919)
-- Name: Options Options_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Options"
    ADD CONSTRAINT "Options_pkey" PRIMARY KEY (options_id);


--
-- TOC entry 2747 (class 2606 OID 16914)
-- Name: Pays Pays_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Pays"
    ADD CONSTRAINT "Pays_pkey" PRIMARY KEY (pays_id);


--
-- TOC entry 2751 (class 2606 OID 16924)
-- Name: Recurence Recurence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Recurence"
    ADD CONSTRAINT "Recurence_pkey" PRIMARY KEY (recurence_id);


--
-- TOC entry 2759 (class 2606 OID 16948)
-- Name: Sous_categorie Sous_categorie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Sous_categorie"
    ADD CONSTRAINT "Sous-categorie_pkey" PRIMARY KEY (sous_categorie_id);


--
-- TOC entry 2745 (class 2606 OID 16906)
-- Name: Statut Statut_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Statut"
    ADD CONSTRAINT "Statut_pkey" PRIMARY KEY (statut_id);


--
-- TOC entry 2755 (class 2606 OID 16937)
-- Name: Transaction Transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaction"
    ADD CONSTRAINT "Transaction_pkey" PRIMARY KEY (transaction_id);


--
-- TOC entry 2761 (class 2606 OID 16953)
-- Name: Type_transaction Type_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Type_transaction"
    ADD CONSTRAINT "Type_transaction_pkey" PRIMARY KEY (type_transaction_id);


--
-- TOC entry 2739 (class 2606 OID 16972)
-- Name: Utilisateur Utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Utilisateur"
    ADD CONSTRAINT "Utilisateur_pkey" PRIMARY KEY (utilisateur_id);


--
-- TOC entry 2743 (class 2606 OID 16895)
-- Name: droit droit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.droit
    ADD CONSTRAINT droit_pkey PRIMARY KEY (droit_id);


--
-- TOC entry 2774 (class 2606 OID 17054)
-- Name: sous_categorie categorie_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Sous_categorie"
    ADD CONSTRAINT categorie_id FOREIGN KEY (categorie_id) REFERENCES public."Categorie"(categorie_id) ON UPDATE CASCADE ON DELETE SET DEFAULT;


--
-- TOC entry 2764 (class 2606 OID 16973)
-- Name: Utilisateur droit_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Utilisateur"
    ADD CONSTRAINT droit_id FOREIGN KEY (droit_id) REFERENCES public.droit(droit_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2773 (class 2606 OID 17049)
-- Name: Transaction modele_transaction_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaction"
    ADD CONSTRAINT modele_transaction_id FOREIGN KEY (modele_transaction_id) REFERENCES public."Modele_transaction"(modele_transaction_id) ON UPDATE CASCADE;


--
-- TOC entry 2767 (class 2606 OID 16999)
-- Name: Utilisateur options_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Utilisateur"
    ADD CONSTRAINT options_id FOREIGN KEY (options_id) REFERENCES public."Options"(options_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2766 (class 2606 OID 16989)
-- Name: Utilisateur pays_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Utilisateur"
    ADD CONSTRAINT pays_id FOREIGN KEY (pays_id) REFERENCES public."Pays"(pays_id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 2776 (class 2606 OID 17009)
-- Name: Limite recurence_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Limite"
    ADD CONSTRAINT recurence_id FOREIGN KEY (recurence_id) REFERENCES public."Recurence"(recurence_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2772 (class 2606 OID 17044)
-- Name: Modele_transaction recurence_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Modele_transaction"
    ADD CONSTRAINT recurence_id FOREIGN KEY (recurence_id) REFERENCES public."Recurence"(recurence_id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 2777 (class 2606 OID 17014)
-- Name: Limite sous_categorie_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Limite"
    ADD CONSTRAINT sous_categorie_id FOREIGN KEY (sous_categorie_id) REFERENCES public."Sous_categorie"("sous_categorie_id") ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2770 (class 2606 OID 17034)
-- Name: Modele_transaction sous_categorie_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Modele_transaction"
    ADD CONSTRAINT sous_categorie_id FOREIGN KEY (sous_categorie_id) REFERENCES public."Sous_categorie"("sous_categorie_id") ON UPDATE CASCADE ON DELETE SET DEFAULT;


--
-- TOC entry 2765 (class 2606 OID 16984)
-- Name: Utilisateur statut_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Utilisateur"
    ADD CONSTRAINT statut_id FOREIGN KEY (statut_id) REFERENCES public."Statut"(statut_id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 2769 (class 2606 OID 17029)
-- Name: Modele_transaction type_transaction_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Modele_transaction"
    ADD CONSTRAINT type_transaction_id FOREIGN KEY (type_transaction_id) REFERENCES public."Type_transaction"(type_transaction_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2768 (class 2606 OID 16994)
-- Name: Notification utilisateur_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Notification"
    ADD CONSTRAINT utilisateur_id FOREIGN KEY (utilisateur_id) REFERENCES public."Utilisateur"(utilisateur_id) ON DELETE CASCADE;


--
-- TOC entry 2775 (class 2606 OID 17004)
-- Name: Limite utilisateur_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Limite"
    ADD CONSTRAINT utilisateur_id FOREIGN KEY (utilisateur_id) REFERENCES public."Utilisateur"(utilisateur_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2771 (class 2606 OID 17039)
-- Name: Modele_transaction utilisateur_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Modele_transaction"
    ADD CONSTRAINT utilisateur_id FOREIGN KEY (utilisateur_id) REFERENCES public."Utilisateur"(utilisateur_id) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2019-03-22 11:33:24

--
-- PostgreSQL database dump complete
--

