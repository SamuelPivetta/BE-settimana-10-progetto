PGDMP                         z            film    14.1    14.1 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    58296    film    DATABASE     `   CREATE DATABASE film WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE film;
                postgres    false            ?            1259    58298    film    TABLE     ?   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            ?            1259    58297    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?          0    58298    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   w       ?           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 10, true);
          public          postgres    false    209            ]           2606    58304    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            ?   ?  x?U????0 ?3|??  PQ@Dt??K?"&a"??g?kw?uW?.i??HC5u?????f兣?D]??U8??T,?ś?????/O??I[?\?c@)?<>3i?????`h??l?B?wH?Ǥ&F????%>??W?N?5?s???l??Vwݦ??k?L]i?a!??????"㸖MIWU?[G??sb??		V5?]QCO,?{?g???ң!9??i??v?hu??????p(>?֋7?<Z?A?KMPߘxF??y??b?Q?6?s-O?:??A?????3
%?
(b???滶mV8??(?????ý???<?n??F? ?|?-s?>?<%Y	޻??h8?d絵???zϳS?qx7?d??M
?-??0]~????'?	?Y??N?????n0e?~?A )??(?,z??     