import {System} from "$lib/domain/entity/sos/System.svelte";

export class AdrWarehouse {

    systemsOfSystems : System[] = $state<System[]>([]);

    constructor() {}

    static create = () : AdrWarehouse => {
        return new AdrWarehouse();
    }

    getSystemOfSystems = (id: string): System | undefined => {

        function traverse(systemOfSystems: System, id: string): System | undefined {
            for (const child of systemOfSystems.systemList) {
                if (child.id === id) {
                    return child;
                }

                const found = traverse(child, id);
                if (found) return found;
            }

            return undefined;
        }

        for (const systemOfSystems of this.systemsOfSystems) {
            if (systemOfSystems.id === id) {
                return systemOfSystems;
            }

            const found = traverse(systemOfSystems, id);
            if (found) return found;
        }

        return undefined; // fallback if nothing found
    };


    getSystems = () : System[] => {

        function traverse(sos : System[], child : System) {
            sos.push(child);

            child.systemList.forEach((system) => {
                traverse(sos, system);
            })
        }

        const sos : System[] = [];

        this.systemsOfSystems.forEach(systemOfSystems => {
            sos.push(systemOfSystems);

            systemOfSystems.systemList.forEach(child => {
                traverse(sos, child);
            })
        })

        return sos;
    }

}