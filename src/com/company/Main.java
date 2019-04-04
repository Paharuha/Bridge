    package com.company;

    public class Main {

        public static void main(String[] args) {
            PlaceCard ticket1 = new OneWayPlaceCard(new PlaceCardBridge());
            ticket1.buy();

            PlaceCard ticket4 = new TwoWayPlaceCard(new PlaceCardBridge());
            ticket4.buy();
            ticket4.returned();

            Compartment ticket2 = new TwoWayCompartment(new CompartmenrBridge());
            ticket2.buy();

            Compartment ticket3 = new OneWayComprtment(new CompartmenrBridge());
            ticket3.buy();


        }
    }

    abstract class PlaceCard {
        IBridge iBridge;

        public PlaceCard(IBridge iBridge) {
            this.iBridge = iBridge;
        }

        public abstract void returned();
        public abstract void buy();
    }

    abstract class Compartment {
        IBridge iBridge;

        public Compartment(IBridge iBridge) {
            this.iBridge = iBridge;
        }

        public abstract void buy();
        public abstract void returned();
    }

    interface IBridge {
        void buy();
        void  returned();
    }

    class PlaceCardBridge implements IBridge{
        @Override
        public void returned() {
            System.out.print("\nБілет Плацкарту");
        }

        @Override
        public void buy() {
            System.out.print("\nБілет Плацкарту");
        }
    }

    class CompartmenrBridge implements IBridge{

        @Override
        public void returned() {
            System.out.print("\nБілет Купе");
        }

        @Override
        public void buy() {
            System.out.print("\nБілет Купе");
        }
    }

    class OneWayPlaceCard extends PlaceCard{
        public OneWayPlaceCard(IBridge iBridge) {
            super(iBridge);
        }

        @Override
        public void returned() {
            iBridge.returned();
            System.out.print(" в одну сторону успішно повернуто");
        }

        @Override
        public void buy() {
            iBridge.buy();
            System.out.print(" в одну сторону успішно придбаний");
        }
    }

    class TwoWayPlaceCard extends PlaceCard{
        public TwoWayPlaceCard(IBridge iBridge) {
            super(iBridge);
        }

        @Override
        public void returned() {
            iBridge.returned();
            System.out.print(" в дві сторону успішно повернуто");
        }

        @Override
        public void buy() {
            iBridge.buy();
            System.out.print(" в дві сторони успішно придбаний");
        }
    }

    class OneWayComprtment extends Compartment{
        public OneWayComprtment(IBridge iBridge) {
            super(iBridge);
        }

        @Override
        public void returned() {
            iBridge.returned();
            System.out.print(" в одну сторону успішно повернуто");
        }

        @Override
        public void buy() {
            iBridge.buy();
            System.out.print(" в одну сторону успішно придбаний ");
        }
    }

    class TwoWayCompartment extends Compartment{
        public TwoWayCompartment(IBridge iBridge) {
            super(iBridge);
        }

        @Override
        public void returned() {
            iBridge.returned();
            System.out.print(" в дві сторону успішно повернуто");
        }

        @Override
        public void buy() {
            iBridge.buy();
            System.out.print(" в дві сторони успішно придбаний ");
        }
    }