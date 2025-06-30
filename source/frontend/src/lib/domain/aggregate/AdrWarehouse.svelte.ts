import {SystemOfSystems} from "$lib/domain/aggregate/SystemOfSystems.svelte.js";
import {AdrWarehouseResponseDto} from "$lib/dto/response/aggregate/adrWarehouseResponseDto";

export class AdrWarehouse {

    systemsOfSystems : SystemOfSystems[] = $state<SystemOfSystems[]>([]);

    constructor() {}

    static create = () : AdrWarehouse => {
        return new AdrWarehouse();
    }

    getSystemOfSystems = (id: string): SystemOfSystems | undefined => {

        function traverse(systemOfSystems: SystemOfSystems, id: string): SystemOfSystems | undefined {
            for (const child of systemOfSystems.childSystems) {
                if (child.system.id === id) {
                    return child;
                }

                const found = traverse(child, id);
                if (found) return found;
            }

            return undefined;
        }

        for (const systemOfSystems of this.systemsOfSystems) {
            if (systemOfSystems.system.id === id) {
                return systemOfSystems;
            }

            const found = traverse(systemOfSystems, id);
            if (found) return found;
        }

        return undefined; // fallback if nothing found
    };


    getSystems = () : SystemOfSystems[] => {

        function traverse(sos : SystemOfSystems[], child : SystemOfSystems) {
            sos.push(child);

            child.childSystems.forEach(childSystem => {
                traverse(sos, childSystem);
            })
        }

        const sos : SystemOfSystems[] = [];

        this.systemsOfSystems.forEach(systemOfSystems => {
            sos.push(systemOfSystems);

            systemOfSystems.childSystems.forEach(child => {
                traverse(sos, child);
            })
        })

        return sos;
    }

}